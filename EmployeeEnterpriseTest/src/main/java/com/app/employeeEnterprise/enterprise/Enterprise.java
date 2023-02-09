package com.app.employeeEnterprise.enterprise;

import com.app.employeeEnterprise.model.Employee;

import java.util.ArrayList;

public class Enterprise implements IEnterprise{

    private final ArrayList<Employee> employees;

    public Enterprise(){

        employees = new ArrayList<>();
    }

    public  void addEmployee(Employee anEmployee){

        employees.add(anEmployee);
    }

    public ArrayList<Employee> getEmployees() {

        return employees;
    }
}
