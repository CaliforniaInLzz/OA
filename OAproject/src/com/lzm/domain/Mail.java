package com.lzm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Mail
  implements Serializable
{
  private Integer id;
  private String sender;
  private String addressee;
  private String title;
  private String context;
  private String accessories;
  private Timestamp sendTime;
  private Boolean isReade;
  private Boolean isDelete;

  public Mail()
  {
  }

  public Mail(String sender, String addressee, String title, String context, String accessories, Timestamp sendTime, Boolean isReade, Boolean isDelete)
  {
    this.sender = sender;
    this.addressee = addressee;
    this.title = title;
    this.context = context;
    this.accessories = accessories;
    this.sendTime = sendTime;
    this.isReade = isReade;
    this.isDelete = isDelete;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSender() {
    return this.sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getAddressee() {
    return this.addressee;
  }

  public void setAddressee(String addressee) {
    this.addressee = addressee;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContext() {
    return this.context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getAccessories() {
    return this.accessories;
  }

  public void setAccessories(String accessories) {
    this.accessories = accessories;
  }

  public Timestamp getSendTime() {
    return this.sendTime;
  }

  public void setSendTime(Timestamp sendTime) {
    this.sendTime = sendTime;
  }

  public Boolean getIsReade() {
    return this.isReade;
  }

  public void setIsReade(Boolean isReade) {
    this.isReade = isReade;
  }

  public Boolean getIsDelete() {
    return this.isDelete;
  }

  public void setIsDelete(Boolean isDelete) {
    this.isDelete = isDelete;
  }
}