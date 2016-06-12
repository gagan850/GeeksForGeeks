package com.tdd.core.atm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tdd.core.account.AccountRequest;
import com.tdd.core.account.AccountResponse;
import com.tdd.core.atm.constant.ATMConstant;
import com.tdd.core.atm.dao.IATMDao;
import com.tdd.core.bank.IBankAccountManager;
import com.tdd.core.user.User;
import com.tdd.exception.NotEnoughCashException;
import com.tdd.exception.NotEnoughUserBalanceException;
import com.tdd.exception.InvalidAmountException;
import com.tdd.exception.InvalidUserException;

/**
 * The Class ATMCore is a service class for the application. It contains the
 * logic for the ATM application
 */
@Service
public class ATMCore {

	/** The atm dao. */
	private IATMDao atmDao;

	/** The bank account manager. */
	private IBankAccountManager bankAccountManager;

	/** The balance. */
	private long balance = 15000;

	/** The user balance. */
	private Map<User, Long> usersBalance = new HashMap<User, Long>();

	/**
	 * This function withdraw cash from the user account and then updates the
	 * ATM balance with the new balance.
	 *
	 * @param request
	 *            the request
	 * @return the response
	 * @throws InvalidAmountException
	 * @throws NotEnoughCashException
	 * @throws InvalidUserException
	 * @throws NotEnoughUserBalanceException
	 */
	public synchronized AccountResponse withdrawCash(final AccountRequest request)
			throws InvalidAmountException, NotEnoughCashException, InvalidUserException, NotEnoughUserBalanceException {
		long atmBalance = this.getAtmBalance();
		long desiredAmount = request.getRequestedAmount();
		if (request.getUser() == null) {
			throw new InvalidUserException("User is not valid.");
		}
		if (!isEnoughUserBalance(request, desiredAmount)) {
			throw new NotEnoughUserBalanceException(
					"The amount entered exceeds the cash available in your account. Please enter a lesser amount.");
		}
		if (!isEnoughCashAvailable(atmBalance, desiredAmount)) {
			throw new NotEnoughCashException(
					"The amount entered exceeds the cash available in the atm. Please enter a lesser amount.");
		}
		if (desiredAmount < ATMConstant.MIN_WITHDRAWAL_PER_TRANSACTION) {
			throw new InvalidAmountException(" The entered amount is less than the minimum allowed amount. "
					+ ATMConstant.MIN_WITHDRAWAL_PER_TRANSACTION
					+ "Please input an amount greater than or equal to Rs. "
					+ ATMConstant.MIN_WITHDRAWAL_PER_TRANSACTION);
		}
		if (desiredAmount > ATMConstant.MAX_WITHDRAWAL_PER_TRANSACTION) {
			throw new InvalidAmountException("The entered amount exceeds maximum withdrawn limit - . "
					+ ATMConstant.MAX_WITHDRAWAL_PER_TRANSACTION + "Please input the correct amount.");
		}
		AccountResponse response = this.bankAccountManager.withdrawMoney(request);
		updateTreasury(atmBalance, response, request);
		return response;
	}

	/**
	 * Checks if is enough user balance.
	 *
	 * @param request
	 *            the request
	 * @param desiredAmount
	 *            the desired amount
	 * @return true, if is enough user balance
	 */
	private boolean isEnoughUserBalance(AccountRequest request, long desiredAmount) {
		long userBalance = usersBalance.get(request.getUser());
		return userBalance >= desiredAmount;
	}

	/**
	 * Checks if is enough cash available.
	 *
	 * @param balance
	 *            the balance
	 * @param desiredAmount
	 *            the desired amount
	 * @return true, if is enough cash available
	 */
	private boolean isEnoughCashAvailable(long balance, long desiredAmount) {
		return balance >= desiredAmount;
	}

	/**
	 * Update treasury.
	 *
	 * @param balance
	 *            the balance
	 * @param response
	 *            the response
	 */
	private void updateTreasury(long balance, AccountResponse response, AccountRequest request) {
		long newATMBalance = balance - response.getWithdrawalMoney();
		long oldUserBalance = usersBalance.get(request.getUser());
		long newUserBalance = oldUserBalance - response.getWithdrawalMoney();
		this.atmDao.updateATMBalance(newATMBalance);
		this.bankAccountManager.updateUserBalance(newUserBalance);
		this.balance = newATMBalance;
		usersBalance.put(request.getUser(), newUserBalance);
	}

	/**
	 * Gets the atm balance.
	 *
	 * @return the atmBalance
	 */
	public long getAtmBalance() {
		return this.balance;
	}

	/**
	 * Gets the user balance.
	 *
	 * @return the user balance
	 */
	public Map<User, Long> getUsersBalance() {
		return usersBalance;
	}

	/**
	 * Sets the users balance.
	 *
	 * @param usersBalance
	 *            the users balance
	 */
	public void setUsersBalance(Map<User, Long> usersBalance) {
		this.usersBalance = usersBalance;
	}
}
