package com.management.student.service;

import org.apache.log4j.Logger;

import com.management.student.dao.UserDao;
import com.management.student.model.User;

/**
 * The Class UserService,a n implementation of user service.
 */
public class UserService implements IUserService {

    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(UserService.class);
    
    /** The login dao. */
    private UserDao userDao;


    /**
     * This API validates the Login cridentials of the user.
     *
     * @param username the username
     * @return true, if successful
     */
    public User getUserByUserName(final String username) {
        User result = null;
        result = userDao.getUserByUserName(username);
        return result;
    }


    /**
     * Gets the user dao.
     *
     * @return the userDao
     */
    public UserDao getUserDao() {
        return userDao;
    }


    /**
     * Sets the user dao.
     *
     * @param userDao the userDao to set
     */
    public void setUserDao(final UserDao userDao) {
        this.userDao = userDao;
    }
    
}
