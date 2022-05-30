package com.app.employeeEnterprise.service;

import com.app.employeeEnterprise.model.Employee;
import com.app.employeeEnterprise.model.Role;

import java.util.List;

public interface IEmployeeService {

    Employee saveEmployee(Employee employee);
    Role saveRole(Role role);
    void addRoleToEmployee(String employeeName, String roleName);
    Employee getEmployee(String employeeName);
    List<Employee> getEmployees(); //not effecient
}
