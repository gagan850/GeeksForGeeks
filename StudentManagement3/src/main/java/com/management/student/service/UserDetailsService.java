package com.management.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.management.student.model.User;
import com.management.student.model.UserDetail;

/**
 * The Class UserDetailsService, an implementation of user details service, 
 * it provides the information of logged in user and inputs to authentication provider.
 */
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    /** The user service. */
    private UserService userService;
    
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userService.getUserDao().getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        authorityList.add(new SimpleGrantedAuthority(user.getAuthorities().get(0)));        
        UserDetail userNew = new UserDetail(user.getUserName(), user.getPassword(), authorityList);        
        return userNew;
    }
    
    /**
     * Gets the user service.
     *
     * @return the userService
     */
    public UserService getUserService() {
        return userService;
    }
    
    /**
     * Sets the user service.
     *
     * @param userService the userService to set
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    
    
}
