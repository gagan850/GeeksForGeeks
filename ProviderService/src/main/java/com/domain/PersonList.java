package com.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="persons")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonList {
 
 @XmlElement(name = "person")
 private List<Person> data;
 
 public List<Person> getData() {
  return data;
 }
 
 public void setData(final List<Person> data) {
  this.data = data;
 }
}