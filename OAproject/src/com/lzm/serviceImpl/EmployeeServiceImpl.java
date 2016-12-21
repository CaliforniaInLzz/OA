package com.lzm.serviceImpl;

import com.lzm.dao.EmployeeDAO;
import com.lzm.domain.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public class EmployeeServiceImpl
{
  private EmployeeDAO employeeDAO;

  public EmployeeDAO getEmployeeDAO()
  {
    return this.employeeDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public boolean check_account_password(String account, String password)
  {
    List Employees = this.employeeDAO.findByAccount(account);

    if ((Employees != null) && (Employees.size() != 0))
    {
      for (Employee employee : Employees)
      {
        if ((employee.getPassword() != null) && 
          (employee.getPassword().equals(password))) {
          return true;
        }
      }
    }
    return false;
  }

  public Employee getEmployeeByAccount(String account)
  {
    List Employees = this.employeeDAO.findByAccount(account);
    return (Employee)Employees.get(0);
  }

  public void update(Employee newEmployee)
  {
    this.employeeDAO.update(newEmployee);
  }

  public List<String> selectAllName()
  {
    List allEmployee = this.employeeDAO.findAll();
    List allEmployeeName = new ArrayList();
    for (Employee employee : allEmployee)
    {
      allEmployeeName.add(employee.getName());
    }

    return allEmployeeName;
  }
}