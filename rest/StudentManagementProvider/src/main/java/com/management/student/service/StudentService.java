package com.management.student.service;


import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.student.dao.IStudentDao;
import com.management.student.model.Student;


/**
 * The Class StudentService, an implementation of student service.
 */
@Service
public class StudentService implements IStudentService {
    
    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(StudentService.class);

    /** The student dao. */
    @Autowired
    private IStudentDao studentDao;
    
    
    /**
     * This API evaluates the list of all the students.
     *
     * @return the all
     */
    public List<Student> getAll() {
        List<Student> studentList = null;
        try {
            studentList = this.studentDao.getAll();

        } catch (IOException exception) {
            logger.error("Exception ocurred while getting list of all the students", exception);
        }
        
        return studentList;    
    }
    
    
    
    /**
     * This API update the specified student's information.
     *
     * @param student the student
     */
    public void update(final Student student) {
        try {
            this.studentDao.update(student);
        } catch (IOException exception) {
            logger.error("Exception ocurred while updaing the infomation of student with roll number : "
                + student.getRollNumber(), exception);
        }
    }
    
    
    /**
     * This API removes the specified student's detail.
     *
     * @param rollNo the roll no
     * @return the viewable
     */
    public void removeStudent(final String rollNo) {
        try {
            this.studentDao.delete(rollNo);
        } catch (IOException exception) {
            logger.error("Exception ocurred while removing the detail of student with roll number : "
                + rollNo, exception);
        }
    }
    
    
    
    /**
     * This API adds the detail of new Student.
     *
     * @param student the student
     */
    public void add(final Student student) {
        try {
            this.studentDao.add(student);
        } catch (IOException exception) {
            logger.error("Exception ocurred while adding student : ", exception);
        }
    }


    /**
     * This API validates if students with specified roll number already exists.
     *
     * @param rollNumber the roll number
     * @return true, if successful
     */
    public boolean alreadyExist(final String rollNumber) {
        boolean result = false;
        try {
            result = this.studentDao.alreadyExist(rollNumber);
        } catch (IOException exception) {
            logger.error("Exception ocurred while checking if student's detail already exist", exception);
        }
        return result;
    }

}