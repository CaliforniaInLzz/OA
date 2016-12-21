package com.lzm.action;

import com.lzm.domain.Employee;
import com.lzm.serviceImpl.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.List;

public class EmployeeAction extends ActionSupport
{
  private String message;
  private Employee employee;
  private List<String> nameList;
  private EmployeeServiceImpl employeeServiceImpl;

  public List<String> getNameList()
  {
    return this.nameList;
  }

  public void setNameList(List<String> nameList) {
    this.nameList = nameList;
  }

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public EmployeeServiceImpl getEmployeeServiceImpl() {
    return this.employeeServiceImpl;
  }

  public void setEmployeeServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
    this.employeeServiceImpl = employeeServiceImpl;
  }

  public String execute() throws Exception
  {
    System.out.println("回到此方法了测试成功恭喜你");
    return super.execute();
  }

  public String loginCheck()
  {
    if (this.employeeServiceImpl.check_account_password(this.employee.getAccount(), this.employee.getPassword()))
    {
      this.employee = this.employeeServiceImpl.getEmployeeByAccount(this.employee.getAccount());

      this.nameList = this.employeeServiceImpl.selectAllName();

      System.out.println(this.nameList);

      return "success";
    }
    this.message = "用户名或者密码错误";
    return "error";
  }

  public String modifyMessage()
  {
    this.employeeServiceImpl.update(this.employee);

    this.nameList = this.employeeServiceImpl.selectAllName();
    System.out.println(this.nameList);
    return "input";
  }
}