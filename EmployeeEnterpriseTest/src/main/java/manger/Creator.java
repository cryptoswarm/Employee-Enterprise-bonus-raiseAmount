package manger;

import employee.Employee;

public class Creator implements ICreator{

    public Employee createAnEmployee(String employeeRegistration, String employeeLastName, String employeeFirstName,
                                     int employeeEchelon, double employeeOldSalary, char performanceGrade)
    {
        return new Employee(employeeRegistration, employeeLastName, employeeFirstName,
                employeeEchelon, employeeOldSalary,performanceGrade);
    }
}
