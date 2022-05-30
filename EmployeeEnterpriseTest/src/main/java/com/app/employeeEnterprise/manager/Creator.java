package com.app.employeeEnterprise.manager;

import com.app.employeeEnterprise.model.Employee;

public class Creator implements ICreator{

    public Employee createAnEmployee(String employeeRegistration, String employeeLastName, String employeeFirstName,
                                     int employeeEchelon, double employeeOldSalary, char performanceGrade, String password)
    {
        return new Employee(employeeRegistration, employeeLastName, employeeFirstName,
                employeeEchelon, employeeOldSalary,performanceGrade, password);
    }
}
