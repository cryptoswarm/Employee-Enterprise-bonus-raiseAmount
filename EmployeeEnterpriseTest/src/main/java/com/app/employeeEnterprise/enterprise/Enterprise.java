package com.app.employeeEnterprise.enterprise;

import com.app.employeeEnterprise.model.IEmployee;

import java.util.ArrayList;

public class Enterprise implements IEnterprise{

    private final ArrayList<IEmployee> employees;

    public Enterprise(){

        employees = new ArrayList<>();
    }

    public  void addEmployee(IEmployee anEmployee){

        employees.add(anEmployee);
    }

    public ArrayList<IEmployee> getEmployees() {

        return employees;
    }
}
