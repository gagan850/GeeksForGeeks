package com.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
public class Person {
 
 private Long id;
 private String firstName;
 private String lastName;
 private Double money;
  
 public Long getId() {
  return id;
 }
 public void setId(final Long id) {
  this.id = id;
 }
 public String getFirstName() {
  return firstName;
 }
 public void setFirstName(final String firstName) {
  this.firstName = firstName;
 }
 public String getLastName() {
  return lastName;
 }
 public void setLastName(final String lastName) {
  this.lastName = lastName;
 }
 public Double getMoney() {
  return money;
 }
 public void setMoney(final Double money) {
  this.money = money;
 }
}