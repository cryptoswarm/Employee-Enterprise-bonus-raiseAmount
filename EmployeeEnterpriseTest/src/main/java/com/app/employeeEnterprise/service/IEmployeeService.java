package com.app.employeeEnterprise.service;

import com.app.employeeEnterprise.dtos.EmployeeDto;
import com.app.employeeEnterprise.dtos.RoleDto;
import com.app.employeeEnterprise.model.Employee;
import com.app.employeeEnterprise.model.Role;

import java.util.List;

public interface IEmployeeService {

    Employee saveEmployee(Employee employee);
    void addRoleToEmployee(String employeeName, String roleName);
    Employee getEmployee(String employeeName);
    List<EmployeeDto> getEmployees(); //not effecient
    List<RoleDto> getEmployeeRoles(String employeeRegistration);
}
