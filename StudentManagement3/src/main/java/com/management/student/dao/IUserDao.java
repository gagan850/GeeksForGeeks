package com.management.student.dao;

import com.management.student.model.User;

public interface IUserDao {

    public abstract User getUserByUserName(String userName);

}