package com.tdd.core.account;

import com.tdd.core.user.User;

/**
 * The Class AccountRequest. Contains the details of an account request.
 */
public class AccountRequest {
	
	/** The user. */
	private User user;
	
	/** The amount. */
	private long requestedAmount;
	
	/**
	 * Instantiates a new account request.
	 *
	 * @param user the user
	 * @param requestedAmount the requested amount
	 */
	public AccountRequest(final User user, final long requestedAmount) {
		this.user = user;
		this.requestedAmount = requestedAmount;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the user to set
	 */
	public void setUser(final User user) {
		this.user = user;
	}

	/**
	 * Gets the requested amount.
	 *
	 * @return the requested amount
	 */
	public long getRequestedAmount() {
		return requestedAmount;
	}

	/**
	 * Sets the requested amount.
	 *
	 * @param requestedAmount the new requested amount
	 */
	public void setRequestedAmount(long requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

}
