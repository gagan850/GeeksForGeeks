package com.management.student.dao;

import java.io.IOException;
import java.util.List;

import com.management.student.dto.PaginationDto;
import com.management.student.model.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface IStudentDao.
 */
public interface IStudentDao {

    /**
     * Gets the all.
     *
     * @return the all
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract List<Student> getAll() throws IOException;

    /**
     * Delete.
     *
     * @param rollNo the roll no
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract void delete(String rollNo) throws IOException;

    /**
     * Update.
     *
     * @param student the student
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract void update(Student student) throws IOException;

    /**
     * Adds the.
     *
     * @param student the student
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract void add(Student student) throws IOException;

    /**
     * Already exist.
     *
     * @param rollNumber the roll number
     * @return true, if successful
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract boolean alreadyExist(String rollNumber) throws IOException;

    /**
     * Gets the all.
     *
     * @param paginationDto the pagination dto
     * @return the all
     * @throws IOException
     */
    public abstract List<Student> getAll(PaginationDto paginationDto) throws IOException;

}