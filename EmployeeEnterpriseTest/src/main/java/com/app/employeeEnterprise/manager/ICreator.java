package com.app.employeeEnterprise.manager;

import com.app.employeeEnterprise.model.Employee;

public interface ICreator {

    Employee createAnEmployee(String employeeRegistration, String employeeLastName, String employeeFirstName,
                                     int employeeEchelon, double employeeOldSalary, char performanceGrade, String password);

}
