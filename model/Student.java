package com.management.student.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

    String rollNumber;
    String name;
    String address;
    int age;
    /**
     * @return the rollNumber
     */
    public String getRollNumber() {
        return rollNumber;
    }
    /**
     * @param rollNumber the rollNumber to set
     */
    public void setRollNumber(final String rollNumber) {
        this.rollNumber = rollNumber;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(final String address) {
        this.address = address;
    }
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(final int age) {
        this.age = age;
    }
    
    
}
