package com.lzm.dao;

import com.lzm.domain.Mail;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MailDAO extends HibernateDaoSupport
{
  private static final Logger log = LoggerFactory.getLogger(MailDAO.class);

  protected void initDao()
  {
  }

  public void save(Mail transientInstance)
  {
    log.debug("saving Mail instance");
    try {
      getHibernateTemplate().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    }
  }

  public void delete(Mail persistentInstance) {
    log.debug("deleting Mail instance");
    try {
      getHibernateTemplate().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Mail findById(Integer id) {
    log.debug("getting Mail instance with id: " + id);
    try {
      return (Mail)getHibernateTemplate().get(
        "com.lzm.domain.Mail", id);
    }
    catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    }
  }

  public List findByExample(Mail instance) {
    log.debug("finding Mail instance by example");
    try {
      List results = getHibernateTemplate().findByExample(instance);
      log.debug("find by example successful, result size: " + 
        results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }

  public List findByProperty(String propertyName, Object value) {
    log.debug("finding Mail instance with property: " + propertyName + 
      ", value: " + value);
    try {
      String queryString = "from Mail as model where model." + 
        propertyName + "= ?";
      return getHibernateTemplate().find(queryString, value);
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    }
  }

  public List findAll()
  {
    log.debug("finding all Mail instances");
    try {
      String queryString = "from Mail";
      return getHibernateTemplate().find(queryString);
    }
    catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    }
  }

  public Mail merge(Mail detachedInstance) {
    log.debug("merging Mail instance");
    try {
      Mail result = (Mail)getHibernateTemplate().merge(
        detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public void attachDirty(Mail instance) {
    log.debug("attaching dirty Mail instance");
    try {
      getHibernateTemplate().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Mail instance) {
    log.debug("attaching clean Mail instance");
    try {
      getHibernateTemplate().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void setDeleteTrue(Timestamp timestamp)
  {
    List allMail = findAll();

    for (Mail mail : allMail)
    {
      System.out.println(mail.getSendTime() + "---------j-----------");
      if (mail.getSendTime().equals(timestamp))
      {
        delete(mail);
        mail.setIsDelete(Boolean.valueOf(true));
        save(mail);
      }
    }
  }

  public void setReadTrue(Timestamp timestamp)
  {
    List allMail = findAll();

    for (Mail mail : allMail)
    {
      System.out.println(mail.getSendTime() + "---------j-----------");
      if (mail.getSendTime().equals(timestamp))
      {
        delete(mail);
        mail.setIsReade(Boolean.valueOf(true));
        save(mail);
      }
    }
  }

  public void setDeleteFalse(Timestamp timestamp)
  {
    List allMail = findAll();

    for (Mail mail : allMail)
    {
      System.out.println(mail.getSendTime() + "---------j-----------");
      if (mail.getSendTime().equals(timestamp))
      {
        delete(mail);
        mail.setIsDelete(Boolean.valueOf(false));
        save(mail);
      }
    }
  }

  public void deleteForever(Timestamp time)
  {
    List allMail = findAll();
    for (Mail mail : allMail)
    {
      System.out.println(mail.getSendTime() + "---------j-----------");
      if (mail.getSendTime().equals(time))
      {
        System.out.println("сю╬ци╬ЁЩ-----------------------------------");
        delete(mail);
      }
    }
  }

  public static MailDAO getFromApplicationContext(ApplicationContext ctx)
  {
    return (MailDAO)ctx.getBean("MailDAO");
  }
}