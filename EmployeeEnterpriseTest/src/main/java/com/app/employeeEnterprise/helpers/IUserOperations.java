package com.app.employeeEnterprise.helpers;

public interface IUserOperations {

    String checkUserRegistrationNbr();
    String checkEmployeeName(String askMsg, String errMsg);
    int checkEmployeeEchelon();
    double checkEmployeeSalary();
    char checkEmployeePerformanceGrade();
    int checkUserChoiceInput();
}

