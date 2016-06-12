package com.tdd.core.atm.dao;



/**
 * The interface IATMDao is DAO layer implementations of the ATM related operations.
 */
public interface IATMDao {

	/**
	 * Update atm balance.
	 *
	 * @param balance the balance
	 */
	public void updateATMBalance(final long balance);
	
}
