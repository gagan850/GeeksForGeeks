package com.management.student.service;

import java.io.IOException;
import java.util.List;

import com.management.student.model.Student;

/**
 * The Interface IStudentService, an interface for student service.
 */
public interface IStudentService {

    /**
     * This API evaluates the list of all the students.
     *
     * @return the all
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract List<Student> getAll() throws IOException;

    /**
     * This API update the specified student's information.
     *
     * @param student the student
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract void update(Student student) throws IOException;

    /**
     * This API removes the specified student's detail.
     *
     * @param rollNo the roll no
     * @return the viewable
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract void removeStudent(String rollNo) throws IOException;

    /**
     * This API adds the detail of new Student.
     *
     * @param student the student
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract void add(Student student) throws IOException;

    /**
     * This API validates if students with specified roll number already exists.
     *
     * @param rollNumber the roll number
     * @return true, if successful
     * @throws IOException 
     */
    public abstract boolean alreadyExist(String rollNumber) throws IOException;

}