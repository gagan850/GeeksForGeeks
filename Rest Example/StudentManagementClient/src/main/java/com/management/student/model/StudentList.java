package com.management.student.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList {

    @XmlElement(name="student")
    private List<Student> students;

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(final List<Student> students) {
        this.students = students;
    }
    
    
    
}
