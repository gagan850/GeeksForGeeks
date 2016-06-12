package com.tdd.core.bank;

import com.tdd.core.account.AccountRequest;
import com.tdd.core.account.AccountResponse;
import com.tdd.exception.InvalidAmountException;
import com.tdd.exception.InvalidUserException;

/**
 * The Interface BankAccountManager is responsible maintaining all users Account.
 */
public interface IBankAccountManager {
	
	/**
	 * Withdraw money.
	 *
	 * @param request the request
	 * @return the account response
	 * @throws InvalidAmountException 
	 * @throws InvalidUserException 
	 */
	AccountResponse withdrawMoney(final AccountRequest request) throws InvalidAmountException, InvalidUserException;

	/**
	 * Update user balance.
	 *
	 * @param expectedBalanceAfterOper the expected balance after oper
	 */
	void updateUserBalance(long expectedBalanceAfterOper);

}
