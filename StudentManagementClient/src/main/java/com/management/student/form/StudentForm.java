package com.management.student.form;

import java.util.List;

import com.management.student.model.Student;

/**
 * The Class StudentForm, is the replica of student UI.
 */
public class StudentForm extends BaseForm {

    /** The student. */
    Student modifyStudent = new Student();
    
    /** The add student. */
    Student addStudent = new Student();
    
    /** The student list. */
    List<Student> studentList;
    
    /**
     * @return the modifyStudent
     */
    public Student getModifyStudent() {
        return modifyStudent;
    }

    /**
     * @param modifyStudent the modifyStudent to set
     */
    public void setModifyStudent(final Student modifyStudent) {
        this.modifyStudent = modifyStudent;
    }

    /**
     * @return the addStudent
     */
    public Student getAddStudent() {
        return addStudent;
    }

    /**
     * @param addStudent the addStudent to set
     */
    public void setAddStudent(final Student addStudent) {
        this.addStudent = addStudent;
    }

    /**
     * Gets the student list.
     *
     * @return the studentList
     */
    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Sets the student list.
     *
     * @param studentList the studentList to set
     */
    public void setStudentList(final List<Student> studentList) {
        this.studentList = studentList;
    }
    
}
