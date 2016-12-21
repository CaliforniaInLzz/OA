package com.lzm.dao;

import com.lzm.domain.Employee;
import java.io.PrintStream;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HolidayDAO extends HibernateDaoSupport
{
  private static final Logger log = LoggerFactory.getLogger(HolidayDAO.class);
  public static final String ACCOUNT = "account";
  public static final String PASSWORD = "password";

  protected void initDao()
  {
  }

  public void save(Employee transientInstance)
  {
    log.debug("saving Employee instance");
    try {
      getHibernateTemplate().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    }
  }

  public void delete(Employee persistentInstance) {
    log.debug("deleting Employee instance");
    try {
      getHibernateTemplate().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Employee findById(Integer id) {
    log.debug("getting Employee instance with id: " + id);
    try {
      return (Employee)getHibernateTemplate().get(
        "com.lzm.domain.Employee", id);
    }
    catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    }
  }

  public List findByExample(Employee instance) {
    log.debug("finding Employee instance by example");
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
    log.debug("finding Employee instance with property: " + propertyName + 
      ", value: " + value);
    try {
      String queryString = "from Employee as model where model." + 
        propertyName + "= ?";
      return getHibernateTemplate().find(queryString, value);
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    }
  }

  public List findByAccount(Object account) {
    return findByProperty("account", account);
  }

  public List findByPassword(Object password) {
    return findByProperty("password", password);
  }

  public List findAll() {
    log.debug("finding all Employee instances");
    try {
      String queryString = "from Employee";
      return getHibernateTemplate().find(queryString);
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    }
  }

  public Employee merge(Employee detachedInstance) {
    log.debug("merging Employee instance");
    try {
      Employee result = (Employee)getHibernateTemplate().merge(
        detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public void attachDirty(Employee instance) {
    log.debug("attaching dirty Employee instance");
    try {
      getHibernateTemplate().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Employee instance) {
    log.debug("attaching clean Employee instance");
    try {
      getHibernateTemplate().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public static HolidayDAO getFromApplicationContext(ApplicationContext ctx) {
    return (HolidayDAO)ctx.getBean("EmployeeDAO");
  }

  public void update(Employee newEmployee)
  {
    Employee oldEmployee = (Employee)findByAccount(newEmployee.getAccount()).get(0);
    delete(oldEmployee);
    save(newEmployee);
    System.out.println("工号为" + newEmployee.getAccount() + "更改了信息");
  }
}