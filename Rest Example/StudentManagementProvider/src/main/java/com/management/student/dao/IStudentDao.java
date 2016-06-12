package com.management.student.dao;

import java.io.IOException;
import java.util.List;

import com.management.student.model.Student;

public interface IStudentDao {

    public abstract List<Student> getAll() throws IOException;

    public abstract void delete(String rollNo) throws IOException;

    public abstract void update(Student student) throws IOException;

    public abstract void add(Student student) throws IOException;

    public abstract boolean alreadyExist(String rollNumber) throws IOException;

}