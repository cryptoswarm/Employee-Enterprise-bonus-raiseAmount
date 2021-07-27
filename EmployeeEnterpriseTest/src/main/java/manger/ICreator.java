package manger;

import employee.Employee;

public interface ICreator {

    Employee createAnEmployee(String employeeRegistration, String employeeLastName, String employeeFirstName,
                                     int employeeEchelon, double employeeOldSalary, char performanceGrade);

}
