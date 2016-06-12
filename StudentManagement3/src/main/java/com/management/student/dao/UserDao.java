package com.management.student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.management.student.model.User;

@Repository
public class UserDao implements IUserDao {

    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(UserDao.class);

    static Map<String, User> usermap = new HashMap<String, User>();

    {

        User user = new User();
        List<String> auth = new ArrayList<String>();
        auth.add("ROLE_ADMIN");
        user.setAuthorities(auth);
        user.setLastName("bansal");
        user.setUserName("ADMIN1234");
        user.setPassword("ADMIN1234");
        usermap.put("ADMIN1234", user);
    }

    /** The jdbc template. */
    private MongoTemplate jdbcTemplate;

    public User getUserByUserName(final String userName) {
        User user = usermap.get(userName);
            //this.jdbcTemplate.findOne(new Query(Criteria.where("userName").is(userName)),User.class);
        return user;
    }

    /**
     * @return the jdbcTemplate
     */
    public MongoTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(final MongoTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
