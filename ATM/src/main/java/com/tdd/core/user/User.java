package com.tdd.core.user;

/**
 * The Class User is a Model class for the user. Encapsulates the details of an ATM user. 
 */
public class User {
	
	/** The name. */
	private String userName;

	/** The account number. */
	private long accountNumber;
	
	/** The atm pin. */
	private int pin;
	
	/**
	 * Instantiates a new user.
	 *
	 * @param userName the name
	 * @param accountNumber the account number
	 * @param pin the atm pin
	 */
	public User(final String userName, final long accountNumber, final int pin) {
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.pin = pin;
	}

    @Override
    public boolean equals(final Object obj) {
        boolean isEqual = Boolean.FALSE;
        if (this == obj) {
            isEqual = Boolean.TRUE;
        } else if (obj instanceof User) {
            User user = (User) obj;
			isEqual = this.getUserName().equals(user.getUserName()) && this.getPin() == user.getPin()
					&& this.getAccountNumber() == user.getAccountNumber();
        }
        return isEqual;
    }


    @Override
    public int hashCode() {
        int result = 0;
        result = (int)this.getPin();
        return result;
    }
    
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets the pin.
	 *
	 * @return the pin
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * Sets the pin.
	 *
	 * @param pin the new pin
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}

}
