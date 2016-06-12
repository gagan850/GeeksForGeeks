package com.tdd.core.account;

/**
 * This interface defines common logic like response for the withdrawal of money.
 */
public interface AccountResponse {
	
	/**
	 * Gets the withdrawal money.
	 *
	 * @return the withdrawal money
	 */
	public long getWithdrawalMoney();
	
}
