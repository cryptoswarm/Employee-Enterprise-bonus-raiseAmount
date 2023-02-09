package com.app.employeeEnterprise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //specify how to generate the id
    private Long id; //map the id as a primary key

    private String registration;
    private String firstName;
    private String lastName;
    private int echelon;
    private double oldSalary;
    private char performanceGrade;

    private String performanceDescription;
    private float bonusRate;
    private double bonus;
    private float salaryRaiseRate;
    private double salaryRaiseAmount;
    private double newSalary;
    private String password;

    public Employee(String firstName,
                    String lastName,
                    int echelon,
                    double newSalary,
                    char performanceGrade){

        this.lastName = lastName;
        this.firstName = firstName;
        this.registration = this.generateRegistration();
        this.echelon = echelon;
        this.newSalary = newSalary;
        this.oldSalary = newSalary;
        this.performanceGrade = performanceGrade;
        this.password = "admin";
    }


    @ManyToMany(fetch = FetchType.EAGER) //loading roles at the same time of loading the employee
    private List<Role> roles = new ArrayList<>();

    private String generateRegistration(){
        return  this.lastName.substring(0, 3) +
                this.firstName.charAt(0) +
                this.id;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public String getRegistration() {
        return registration;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public double getSalaryRaiseAmount() {
        return salaryRaiseAmount;
    }

    public float getSalaryRaiseRate() {
        return salaryRaiseRate;
    }

    public float getBonusRate() {
        return bonusRate;
    }

    public double getBonus() {
        return bonus;
    }

    public String getPerformanceDescription() {
        return performanceDescription;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEchelon() {
        return echelon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
