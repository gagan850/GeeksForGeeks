package com.tdd.exception;

/**
 * The Class InvalidUserException extends Exception. it is thrown when the user is null or invalid.
 */
public class InvalidUserException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8399296278373441149L;

	/** The message. */
	private String message = null;
	
	/**
	 * Instantiates a new invalid user exception.
	 *
	 * @param message the message
	 */
	public InvalidUserException(final String message) {
		super(message);
	}
	
	/**
	 * Instantiates a new invalid amount exception.
	 *
	 * @param cause the cause
	 */
	public InvalidUserException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}
}
