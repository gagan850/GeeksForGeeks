package com.tdd.exception;

/**
 * The Class NotEnoughCashException is user defined exception class. It is
 * thrown when ATM doesn't have sufficient balance to operate
 */
public class NotEnoughCashException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8606807182041364858L;

	/** The message. */
	private String message = null;

	/**
	 * Instantiates a new not enough cash exception.
	 *
	 * @param message the message
	 */
	public NotEnoughCashException(final String message) {
		super(message);
	}
	
	/**
	 * Instantiates a new invalid amount exception.
	 *
	 * @param cause the cause
	 */
	public NotEnoughCashException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}
}
