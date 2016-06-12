/*
 * 
 */
package com.management.student.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class User, entity for log in user, which maps to mongoDB collection.s
 */
@Document(collection="User")
public class User {

    /** The user name. */
    String userName;
    
    /** The last name. */
    String lastName;
    
    /** The password. */
    String password;
    
    /** The authorities. */
    List<String> authorities;

    /**
     * Gets the user name.
     *
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the userName to set
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * Gets the last name.
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the authorities.
     *
     * @return the authorities
     */
    public List<String> getAuthorities() {
        return authorities;
    }

    /**
     * Sets the authorities.
     *
     * @param authorities the authorities to set
     */
    public void setAuthorities(final List<String> authorities) {
        this.authorities = authorities;
    }
    
    
    
    
}
