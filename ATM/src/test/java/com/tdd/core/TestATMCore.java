package com.tdd.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tdd.core.account.AccountRequest;
import com.tdd.core.account.AccountResponse;
import com.tdd.core.atm.ATMCore;
import com.tdd.core.atm.dao.IATMDao;
import com.tdd.core.bank.IBankAccountManager;
import com.tdd.core.user.User;
import com.tdd.exception.NotEnoughCashException;
import com.tdd.exception.NotEnoughUserBalanceException;

import com.tdd.exception.InvalidAmountException;
import com.tdd.exception.InvalidUserException;

/**
 * The class is a test class for the ATMCore implementation and contains test
 * cases for
 */
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class TestATMCore {

	/** The atm core. */
	@InjectMocks
	private ATMCore atmCore;

	/** The atm dao. */
	@Mock
	private IATMDao atmDao;

	/** The account request. */
	private AccountRequest request;

	/** The bank account manager. */
	@Mock
	private IBankAccountManager bankAccountManager;

	/**
	 * Sets the up.
	 * 
	 * @throws InvalidUserException
	 * @throws InvalidAmountException
	 */
	@Before
	public void setUp() throws InvalidAmountException, InvalidUserException {

		MockitoAnnotations.initMocks(this);
		long amountRequested = 250l;
		User user = new User("Ravi", 345678, 1010);
		this.request = new AccountRequest(user, amountRequested);
		AccountResponse accountResponse = mock(AccountResponse.class);
		when(accountResponse.getWithdrawalMoney()).thenReturn(this.request.getRequestedAmount());
		when(this.bankAccountManager.withdrawMoney(this.request)).thenReturn(accountResponse);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.atmCore = null;
		this.request = null;
		this.bankAccountManager = null;
		this.atmDao = null;
	}

	/**
	 * Test the atm core refrences.
	 */
	@Test
	public void testATMCore() {
		assertNotNull("ATM core object is null", this.atmCore);
		assertNotNull("Bank account manager is null", this.bankAccountManager);
		assertNotNull("Atm dao mock is null", this.atmDao);
	}

	/**
	 * Test withdraw money.
	 *
	 * @throws NotEnoughCashException
	 *             the not enough cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughUserBalanceException
	 */
	@Test
	public void testWithdrawMoney()
			throws NotEnoughCashException, InvalidUserException, InvalidAmountException, NotEnoughUserBalanceException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 15000l);
		AccountResponse response = this.atmCore.withdrawCash(request);
		long withdrawnMoney = response.getWithdrawalMoney();
		assertEquals("Withdrawn cash is different to expected", 250l, withdrawnMoney, 0);
	}

	/**
	 * Test atm balance after withdrawal.
	 *
	 * @throws NotEnoughCashException
	 *             the not enough cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughUserBalanceException
	 */
	@Test
	public void testATMBalanceAfterWithdrawal()
			throws NotEnoughCashException, InvalidUserException, InvalidAmountException, NotEnoughUserBalanceException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 18000l);
		long expectedBalanceAfterOper = 14750l;
		this.atmCore.withdrawCash(request);
		verify(this.atmDao).updateATMBalance(expectedBalanceAfterOper);
		assertEquals("Available balance in ATM is incorrect after withdrawal ", expectedBalanceAfterOper,
				this.atmCore.getAtmBalance());
	}

	/**
	 * Test atm balance after withdrawal.
	 *
	 * @throws NotEnoughCashException
	 *             the not enough cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughUserBalanceException
	 */
	@Test
	public void testUserBalanceAfterWithdrawal()
			throws NotEnoughCashException, InvalidUserException, InvalidAmountException, NotEnoughUserBalanceException {
		long expectedBalanceAfterOper = 750l;
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 1000l);
		this.atmCore.withdrawCash(request);
		verify(this.bankAccountManager).updateUserBalance(expectedBalanceAfterOper);
		long balanceAfterOper = this.atmCore.getUsersBalance().get(request.getUser());
		assertEquals("Available balance in user account is incorrect after withdrawal ", expectedBalanceAfterOper,
				balanceAfterOper);
	}

	/**
	 * Test null user.
	 *
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughCashException
	 *             the insufficient cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws NotEnoughUserBalanceException
	 */
	@Test(expected = InvalidUserException.class)
	public void testNullUser()
			throws InvalidAmountException, NotEnoughCashException, InvalidUserException, NotEnoughUserBalanceException {
		final AccountRequest reques = new AccountRequest(null, 250l);
		this.atmCore.withdrawCash(reques);
	}

	/**
	 * Test greater than max allowed amt withdrawal.
	 *
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughCashException
	 *             the insufficient cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws NotEnoughUserBalanceException
	 */
	@Test(expected = InvalidAmountException.class)
	public void testGreaterThanMaxAllowedAmtWithdrawal()
			throws InvalidAmountException, NotEnoughCashException, InvalidUserException, NotEnoughUserBalanceException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 15000l);
		AccountRequest request = new AccountRequest(new User("Ravi", 345678, 1010), 7000);
		this.atmCore.withdrawCash(request);
	}

	/**
	 * Test less than min allowed amt withdrawal.
	 *
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughCashException
	 *             the not enough cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws NotEnoughUserBalanceException
	 *             the not enough user balance exception
	 */
	@Test(expected = InvalidAmountException.class)
	public void testLessThanMinAllowedAmtWithdrawal()
			throws InvalidAmountException, NotEnoughCashException, InvalidUserException, NotEnoughUserBalanceException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 15000l);
		AccountRequest request = new AccountRequest(new User("Ravi", 345678, 1010), 50);
		this.atmCore.withdrawCash(request);
	}

	/**
	 * Test negative amount withdrawal.
	 *
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughCashException
	 *             the insufficient cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws NotEnoughUserBalanceException
	 */
	@Test(expected = InvalidAmountException.class)
	public void testNegativeAmountWithdrawal()
			throws InvalidAmountException, NotEnoughCashException, InvalidUserException, NotEnoughUserBalanceException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 15000l);
		AccountRequest request = new AccountRequest(new User("Ravi", 345678, 1010), -100);
		this.atmCore.withdrawCash(request);
	}

	/**
	 * Test not enough cash.
	 *
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughCashException
	 *             the insufficient cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws NotEnoughUserBalanceException
	 */
	@Test(expected = NotEnoughCashException.class)
	public void testNotEnoughCash()
			throws InvalidAmountException, NotEnoughCashException, InvalidUserException, NotEnoughUserBalanceException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 18000l);
		AccountRequest request = new AccountRequest(new User("Ravi", 345678, 1010), 16000);
		this.atmCore.withdrawCash(request);
	}

	/**
	 * Test not enough user balance.
	 *
	 * @throws InvalidAmountException the invalid amount exception
	 * @throws NotEnoughCashException the not enough cash exception
	 * @throws InvalidUserException the invalid user exception
	 * @throws NotEnoughUserBalanceException the not enough user balance exception
	 */
	@Test(expected = NotEnoughUserBalanceException.class)
	public void testNotEnoughUserBalance()
			throws InvalidAmountException, NotEnoughCashException, InvalidUserException, NotEnoughUserBalanceException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 5000l);
		AccountRequest request = new AccountRequest(new User("Ravi", 345678, 1010), 16000);
		this.atmCore.withdrawCash(request);
	}
	/**
	 * Check response time of the function.
	 *
	 * @throws InvalidAmountException
	 *             the invalid amount exception
	 * @throws NotEnoughCashException
	 *             the insufficient cash exception
	 * @throws InvalidUserException
	 *             the invalid user exception
	 * @throws NotEnoughUserBalanceException
	 */
	@Test
	public void checkResponseType()
			throws InvalidAmountException, NotEnoughUserBalanceException, InvalidUserException, NotEnoughCashException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 18000l);
		assertThat(this.atmCore.withdrawCash(request), is(AccountResponse.class));
	}

}
