package com.management.student.form;

/**
 * The Class BaseForm, contains the basic paramaters, which need to be sexist in each form. 
 */
public class BaseForm {

    /** The user name. */
    String userName;
    
    /** The action. */
    String action;
    
    /** The status. */
    String status;
    
    /** The message. */
    String message;

    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(final String action) {
        this.action = action;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(final String message) {
        this.message = message;
    }
        
}

