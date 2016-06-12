package com.tdd.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tdd.core.account.AccountRequest;
import com.tdd.core.account.AccountResponse;
import com.tdd.core.atm.ATMCore;
import com.tdd.core.atm.constant.ATMConstant;
import com.tdd.core.atm.dao.IATMDao;
import com.tdd.core.bank.IBankAccountManager;
import com.tdd.core.user.User;
import com.tdd.exception.InvalidAmountException;
import com.tdd.exception.InvalidUserException;

/**
 * The Class TestATMCoreMultiThread. Tests ATM core implementation for simultaneous access by multiple users.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestMultiThreadingInATM {
	
	/** The atm core. */
	@InjectMocks
	private ATMCore atmCore;
	
	/** The atm dao. */
	@Mock
	private IATMDao atmDao;

	/** The bank account manager. */
	@Mock
	private IBankAccountManager bankAccountManager;
	
	/** The account request. */
	private AccountRequest request1;
	
	/** The account request2. */
	private AccountRequest request2;
	
	/** The executor. */
	private ExecutorService executor;

	
	/**
	 * Sets the up.
	 * @throws InvalidUserException 
	 * @throws InvalidAmountException 
	 */
	@Before
	public void setUp() throws InvalidAmountException, InvalidUserException {
		//initialize annotated mock
		MockitoAnnotations.initMocks(this);
		long requestedAmount = 250l;
		User user1 = new User("Ravi", 345678, 1010);
		this.request1 = new AccountRequest(user1, requestedAmount);
		User user2 = new User("Rajat", 12345, 2020);
		this.request2 = new AccountRequest(user2, requestedAmount);
		AccountResponse accountResponse = mock(AccountResponse.class);
		when(accountResponse.getWithdrawalMoney()).thenReturn(requestedAmount);
		when(bankAccountManager.withdrawMoney(this.request1)).thenReturn(accountResponse);
		when(bankAccountManager.withdrawMoney(this.request2)).thenReturn(accountResponse);
	}
	
	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.request1 = null;
		this.request2 = null;
		this.bankAccountManager = null;
		this.atmDao = null;
	}
	
	/**
	 * Test simultaneous multi withdrawal.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws ExecutionException the execution exception
	 */
	@Test
	public void testSimultaneousMultiWithdrawal() throws InterruptedException, ExecutionException {
		this.atmCore.getUsersBalance().put(new User("Ravi", 345678, 1010), 18000l);
		this.atmCore.getUsersBalance().put(new User("Rajat", 12345, 2020), 18000l);
		this.executor = Executors.newFixedThreadPool(ATMConstant.THREAD_CNT);
		Set<Future<AccountResponse>> taskSet = new HashSet<Future<AccountResponse>>(ATMConstant.THREAD_CNT);
		//Creating the callable tasks
		final Callable<AccountResponse> task1 = new Callable<AccountResponse>() {
			
			@Override
			public AccountResponse call() throws Exception {
					return atmCore.withdrawCash(request1);
			}
		};
		final Callable<AccountResponse> task2 = new Callable<AccountResponse>() {
			
			@Override
			public AccountResponse call() throws Exception {
					return atmCore.withdrawCash(request2);
			}
		};
		//submitting the tasks to the executor
		Future<AccountResponse> future1 = this.executor.submit(task1);
		Future<AccountResponse> future2 = this.executor.submit(task2);		
		taskSet.add(future1);
		taskSet.add(future2);
		this.executor.shutdown();
		for (Future<AccountResponse> future : taskSet) {
			AccountResponse accountResponse = future.get();
			assertEquals(250l, accountResponse.getWithdrawalMoney());
		}
		assertEquals(14500l, this.atmCore.getAtmBalance());
	}
	
}
