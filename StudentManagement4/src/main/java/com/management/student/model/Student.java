package com.management.student.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class Student, entity for student, which maps to mongodb collection.
 */

@Document(collection="Student")
public class Student implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2022572325788662383L;

    /** The roll number. */
    @Id
    @Size(min = 1000, max = 9999, message = "Roll Number should contain 4 digits")
    String rollNumber;
    
    /** The name. */
    @NotEmpty(message = "Name should not be empty")
    String name;
    
    /** The address. */
    String address;
    
    /** The age. */
    int age;
    
    /**
     * Gets the roll number.
     *
     * @return the rollNumber
     */
    public String getRollNumber() {
        return rollNumber;
    }
    
    /**
     * Sets the roll number.
     *
     * @param rollNumber the rollNumber to set
     */
    public void setRollNumber(final String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }
    
    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Sets the address.
     *
     * @param address the address to set
     */
    public void setAddress(final String address) {
        this.address = address;
    }
    
    /**
     * Gets the age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Sets the age.
     *
     * @param age the age to set
     */
    public void setAge(final int age) {
        this.age = age;
    }

    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Student [rollNumber=" + rollNumber + ", name=" + name + ", address=" + address + ", age=" + age + "]";
    }
    
    /**
     * Instantiates a new student.
     *
     * @param rollNumber the roll number
     */
    public Student(final String rollNumber) {
        super();
        this.rollNumber = rollNumber;
    }
    
    /**
     * Instantiates a new student.
     */
    public Student() {
        super();
    }
    
    
    
}