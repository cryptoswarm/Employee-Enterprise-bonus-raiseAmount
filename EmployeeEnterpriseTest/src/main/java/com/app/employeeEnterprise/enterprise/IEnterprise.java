package com.app.employeeEnterprise.enterprise;

import com.app.employeeEnterprise.model.Employee;

import java.util.ArrayList;

public interface IEnterprise {

    void addEmployee(Employee anEmployee);
    ArrayList<Employee> getEmployees();
}
