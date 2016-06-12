package com.tdd.exception;

/**
 * The Class NotEnoughUserBalanceException.
 */
public class NotEnoughUserBalanceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7644353932204312709L;

	/** The message. */
	private String message = null;
	
	/**
	 * Instantiates a new invalid amount exception.
	 *
	 * @param message
	 *            the message
	 */
	public NotEnoughUserBalanceException(final String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Instantiates a new invalid amount exception.
	 *
	 * @param cause the cause
	 */
	public NotEnoughUserBalanceException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}
}
