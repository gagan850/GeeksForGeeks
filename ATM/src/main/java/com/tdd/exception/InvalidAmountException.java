package com.tdd.exception;

/**
 * The Class InvalidAmountException extends Exception and is thrown when user
 * enters a negative value or value less than the minimum permissible value or
 * value greater than maximum permissible value.
 */
public class InvalidAmountException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2657936282417463987L;

	/** The message. */
	private String message = null;
	
	/**
	 * Instantiates a new invalid amount exception.
	 *
	 * @param message
	 *            the message
	 */
	public InvalidAmountException(final String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Instantiates a new invalid amount exception.
	 *
	 * @param cause the cause
	 */
	public InvalidAmountException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}
}
