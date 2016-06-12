package com.management.student.constant;

/**
 * The Class FormParams, contains the html form parameters,
 *  which need to be accessed at server side.
 * Final , should not get extended.
 * Private Constructor, To restrict the instantiation of the class 
 */
public final class FormParams {

    /** The Constant NAME. */
    public static final String NAME = "name";
    
    /** The Constant AGE. */
    public static final String AGE = "age";
    
    /** The Constant ADDRESS. */
    public static final String ADDRESS = "address";
    
    /** The Constant ROLL_NO. */
    public static final String ROLL_NO = "rollNumber";
    
    /** The Constant LOGIN_ID. */
    public static final String LOGIN_ID = "loginId";
    
    /** The Constant PASSWORD. */
    public static final String PASSWORD = "password";
   
    /**
     * Instantiates a new form params.
     */
    private FormParams () {
        
    }
}
