package com.management.student.dao;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.management.student.model.User;

@Repository
public class UserDao implements IUserDao {
    
    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(UserDao.class);
    
    /** The jdbc template. */
    private MongoTemplate jdbcTemplate;
    
    public User getUserByUserName(final String userName) {
        User user = this.jdbcTemplate.findOne(new Query(Criteria.where("userName").is(userName)),User.class);             
        return user;
    }

    /**
     * @return the jdbcTemplate
     */
    public MongoTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(final MongoTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
}
