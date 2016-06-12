package com.management.student.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;


/**
 * The Class UserDetail, implementation of User Details, which contains the logged in user's detail
 *  and input to authentication provider.
 */
public class UserDetail extends org.springframework.security.core.userdetails.User {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7860003778661492112L;

    /**
     * Instantiates a new user.
     *
     * @param username the username
     * @param password the password
     * @param authorities the authorities
     */
    public UserDetail(final String username, final String password, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
   
    }


    
}
