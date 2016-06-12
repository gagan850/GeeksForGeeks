package com.management.student.service;

import com.management.student.model.User;

/**
 * The Interface IUserService, an interface for user service.
 */
public interface IUserService {

    /**
     * This API validates the Login cridentials of the user.
     *
     * @param login the login
     * @return true, if successful
     */
    public abstract User getUserByUserName(String username);

}