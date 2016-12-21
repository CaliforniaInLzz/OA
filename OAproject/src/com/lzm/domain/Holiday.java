package com.lzm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Holiday
  implements Serializable
{
  private Integer id;
  private String proposer;
  private Timestamp beginTime;
  private Timestamp endTime;
  private String isCheck;
  private String reson;
  private String checker;

  public Holiday()
  {
  }

  public Holiday(String isCheck)
  {
    this.isCheck = isCheck;
  }

  public Holiday(String proposer, Timestamp beginTime, Timestamp endTime, String isCheck, String reson, String checker)
  {
    this.proposer = proposer;
    this.beginTime = beginTime;
    this.endTime = endTime;
    this.isCheck = isCheck;
    this.reson = reson;
    this.checker = checker;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProposer() {
    return this.proposer;
  }

  public void setProposer(String proposer) {
    this.proposer = proposer;
  }

  public Timestamp getBeginTime() {
    return this.beginTime;
  }

  public void setBeginTime(Timestamp beginTime) {
    this.beginTime = beginTime;
  }

  public Timestamp getEndTime() {
    return this.endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }

  public String getIsCheck() {
    return this.isCheck;
  }

  public void setIsCheck(String isCheck) {
    this.isCheck = isCheck;
  }

  public String getReson() {
    return this.reson;
  }

  public void setReson(String reson) {
    this.reson = reson;
  }

  public String getChecker() {
    return this.checker;
  }

  public void setChecker(String checker) {
    this.checker = checker;
  }
}