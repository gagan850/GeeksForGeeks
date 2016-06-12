package com.management.student.dao;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.management.student.model.Student;

@Repository
public class StudentDao implements IStudentDao {

    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(StudentDao.class);
    
    /** The jdbc template. */
    @Autowired
    private MongoTemplate jdbcTemplate;
    
    public List<Student> getAll() throws IOException {
        List<Student> studentList = jdbcTemplate.findAll(Student.class);           
        logger.debug("Fetched student List : " + studentList);
        return studentList;        
    }
    

    
    public void delete(final String rollNo) throws IOException {
        logger.debug("deleting student with roll no : " + rollNo);
        Query query = new Query(Criteria.where("rollNumber").is(rollNo));
        jdbcTemplate.remove(query, Student.class);
        logger.debug("student with roll no : " + rollNo + " has been deleted successfully");
    }

    public void update(final Student student) throws IOException {
        logger.debug("updating student with roll no : " + student.getRollNumber());
        Update update = new Update();
        
        update.set("name", student.getName());
        update.set("age", student.getAge());
        update.set("address", student.getAddress());
        jdbcTemplate
            .updateMulti(new Query(Criteria.where("rollNumber").is(student.getRollNumber())), update, Student.class);

        logger.debug("student with roll no : " + student.getRollNumber() + " has been updated successfully");
    }

    public void add(final Student student) throws IOException {
        logger.debug("adding student with detail : " + student);
        jdbcTemplate.insert(student);
        logger.debug("student with detail : " + student + "has been added successfully");
    }



    public boolean alreadyExist(final String rollNumber) throws IOException {
        boolean result = false;

        Student student = this.jdbcTemplate.findOne(new Query(Criteria.where("rollNumber").is(rollNumber)), Student.class);
        if(student != null) {
            logger.debug("student with roll number : "+ rollNumber + " alredy Exist");
            result = true;
        }

        return result;
    }
    
}