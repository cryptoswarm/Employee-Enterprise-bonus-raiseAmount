package com.app.employeeEnterprise.enterprise;

import com.app.employeeEnterprise.model.IEmployee;

import java.util.ArrayList;

public interface IEnterprise {

    void addEmployee(IEmployee anEmployee);
    ArrayList<IEmployee> getEmployees();
}
