package com.lzm.action;

import com.lzm.domain.Mail;
import com.lzm.serviceImpl.MailServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;

public class MailAction extends ActionSupport
  implements ServletResponseAware
{
  String aa = "bb";
  private Mail mail;
  private MailServiceImpl mailServiceImpl;
  private String nickname;
  HttpServletResponse response = null;
  private Timestamp sendTime;

  public String getAa()
  {
    return this.aa;
  }

  public void setAa(String aa) {
    this.aa = aa;
  }

  public Mail getMail()
  {
    return this.mail;
  }

  public void setMail(Mail mail) {
    this.mail = mail;
  }

  public MailServiceImpl getMailServiceImpl()
  {
    return this.mailServiceImpl;
  }

  public void setMailServiceImpl(MailServiceImpl mailServiceImpl) {
    this.mailServiceImpl = mailServiceImpl;
  }

  public void sendMail()
  {
    Timestamp now = new Timestamp(new Date().getTime());

    System.out.println("回到发送邮件了");
    this.mail.setIsReade(Boolean.valueOf(false));
    this.mail.setSendTime(now);
    this.mail.setIsDelete(Boolean.valueOf(false));
    this.mailServiceImpl.saveMail(this.mail);
  }

  public String getNickname()
  {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public void getMailMessage()
    throws IOException
  {
    String str = this.mailServiceImpl.getMailMessage(this.nickname);

    this.response.setCharacterEncoding("UTF-8");
    this.response.setContentType("application/json");
    PrintWriter out = this.response.getWriter();
    System.out.println(str);
    out.write(str);
  }

  public void setServletResponse(HttpServletResponse response)
  {
    this.response = response;
  }

  public void setDeleteTrue()
  {
    this.mailServiceImpl.setDelete(this.sendTime);
  }

  public Timestamp getSendTime()
  {
    return this.sendTime;
  }

  public void setSendTime(Timestamp sendTime) {
    this.sendTime = sendTime;
  }

  public void setReadTrue()
  {
    this.mailServiceImpl.setReadTrue(this.sendTime);
  }

  public void getGarbageMailMessage()
    throws IOException
  {
    String str = this.mailServiceImpl.getGarbageMailMessage(this.nickname);

    this.response.setCharacterEncoding("UTF-8");
    this.response.setContentType("application/json");
    PrintWriter out = this.response.getWriter();
    System.out.println(str);
    out.write(str);
  }

  public void setDeleteFalse()
  {
    this.mailServiceImpl.setDeleteFalse(this.sendTime);
  }

  public void deleteForever()
  {
    this.mailServiceImpl.deleteForever(this.sendTime);
  }
}