package com.lzm.serviceImpl;

import com.lzm.dao.MailDAO;
import com.lzm.domain.Mail;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Transactional
public class MailServiceImpl
{
  private MailDAO mailDAO;

  public MailDAO getMailDAO()
  {
    return this.mailDAO;
  }

  public void setMailDAO(MailDAO mailDAO) {
    this.mailDAO = mailDAO;
  }

  public void saveMail(Mail mail)
  {
    this.mailDAO.save(mail);
  }

  public String getMailMessage(String name)
  {
    List AllMail = this.mailDAO.findAll();
    System.out.println(AllMail);
    List Mails = new ArrayList();
    for (Mail mail : AllMail)
    {
      if ((name != null) && (name.equals(mail.getAddressee())) && (!mail.getIsDelete().booleanValue()))
      {
        Mails.add(mail);
      }
    }

    if (Mails.size() == 0) {
      return "{\"count\":\"nothing\"}";
    }

    String str = "{\"count\":\"" + Mails.size() + "\"";
    int i = 0;
    for (Mail mail : Mails) {
      boolean isReade = mail.getIsReade().booleanValue();
      String isReadStr = "";
      if (isReade)
      {
        isReadStr = "ÒÑ¶Á";
      }
      else {
        isReadStr = "Î´¶Á";
      }
      str = str + ",\"title" + i + "\":\"" + mail.getTitle() + "\"";
      str = str + ",\"context" + i + "\":\"" + mail.getContext() + "\"";
      str = str + ",\"sender" + i + "\":\"" + mail.getSender() + "\"";
      str = str + ",\"sendTime" + i + "\":\"" + mail.getSendTime() + "\"";
      str = str + ",\"isReade" + i + "\":\"" + isReadStr + "\"";
      i++;
    }
    str = str + "}";
    return str;
  }

  public void setDelete(Timestamp timestamp)
  {
    this.mailDAO.setDeleteTrue(timestamp);
  }

  public void setDeleteFalse(Timestamp timestamp)
  {
    this.mailDAO.setDeleteFalse(timestamp);
  }

  public void setReadTrue(Timestamp timestamp)
  {
    this.mailDAO.setReadTrue(timestamp);
  }

  public String getGarbageMailMessage(String name)
  {
    List AllMail = this.mailDAO.findAll();
    System.out.println(AllMail);
    List Mails = new ArrayList();
    for (Mail mail : AllMail)
    {
      if ((name != null) && (name.equals(mail.getAddressee())) && (mail.getIsDelete().booleanValue()))
      {
        Mails.add(mail);
      }
    }

    if (Mails.size() == 0) {
      return "{\"count\":\"nothing\"}";
    }

    String str = "{\"count\":\"" + Mails.size() + "\"";
    int i = 0;
    for (Mail mail : Mails) {
      boolean isReade = mail.getIsReade().booleanValue();
      String isReadStr = "";
      if (isReade)
      {
        isReadStr = "ÒÑ¶Á";
      }
      else {
        isReadStr = "Î´¶Á";
      }
      str = str + ",\"title" + i + "\":\"" + mail.getTitle() + "\"";
      str = str + ",\"context" + i + "\":\"" + mail.getContext() + "\"";
      str = str + ",\"sender" + i + "\":\"" + mail.getSender() + "\"";
      str = str + ",\"sendTime" + i + "\":\"" + mail.getSendTime() + "\"";
      str = str + ",\"isReade" + i + "\":\"" + isReadStr + "\"";
      i++;
    }
    str = str + "}";
    return str;
  }

  public void deleteForever(Timestamp time)
  {
    this.mailDAO.deleteForever(time);
  }
}