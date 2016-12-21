package com.lzm.domain;

import java.io.Serializable;

public class Employee
  implements Serializable
{
  private Integer id;
  private String account;
  private String password;
  private String name;
  private Integer age;
  private String sex;
  private String tel;
  private String address;
  private Boolean isManager;

  public Boolean getIsManager()
  {
    return this.isManager;
  }

  public void setIsManager(Boolean isManager) {
    this.isManager = isManager;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getTel() {
    return this.tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Employee()
  {
  }

  public Employee(String account, String password)
  {
    this.account = account;
    this.password = password;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAccount() {
    return this.account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}