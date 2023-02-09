package com.app.employeeEnterprise.dtos;

public record EmployeeDto(
        String employeeRegistration,
        String employeeLastName,
        String employeeFirstName,
        int employeeEchelon,
        double employeeOldSalary,
        char performanceGrade){}
