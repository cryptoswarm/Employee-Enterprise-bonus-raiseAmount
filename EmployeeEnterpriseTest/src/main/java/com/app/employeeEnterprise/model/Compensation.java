package com.app.employeeEnterprise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //specify how to generate the id
    private Long id; //map the id as a primary key
    private Long employeeId;
    private int echelon;
    private double oldSalary;
    private char performanceGrade;
    private String performanceDescription;
    private float bonusRate;
    private double bonus;
    private float salaryRaiseRate;
    private double salaryRaiseAmount;
    private double newSalary;

    public Compensation(Long employeeId,
                        int echelon,
                        char performanceGrade,
                        String performanceDescription,
                        float bonusRate,
                        double bonus,
                        float salaryRaiseRate,
                        double salaryRaiseAmount,
                        double newSalary) {
        this.employeeId = employeeId;
        this.echelon = echelon;
        this.oldSalary = newSalary;
        this.performanceGrade = performanceGrade;
        this.performanceDescription = performanceDescription;
        this.bonusRate = bonusRate;
        this.bonus = bonus;
        this.salaryRaiseRate = salaryRaiseRate;
        this.salaryRaiseAmount = salaryRaiseAmount;
        this.newSalary = newSalary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public int getEchelon() {
        return echelon;
    }

    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }

    public double getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(double oldSalary) {
        this.oldSalary = oldSalary;
    }

    public char getPerformanceGrade() {
        return performanceGrade;
    }

    public void setPerformanceGrade(char performanceGrade) {
        this.performanceGrade = performanceGrade;
    }

    public String getPerformanceDescription() {
        return performanceDescription;
    }

    public void setPerformanceDescription(String performanceDescription) {
        this.performanceDescription = performanceDescription;
    }

    public float getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(float bonusRate) {
        this.bonusRate = bonusRate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public float getSalaryRaiseRate() {
        return salaryRaiseRate;
    }

    public void setSalaryRaiseRate(float salaryRaiseRate) {
        this.salaryRaiseRate = salaryRaiseRate;
    }

    public double getSalaryRaiseAmount() {
        return salaryRaiseAmount;
    }

    public void setSalaryRaiseAmount(double salaryRaiseAmount) {
        this.salaryRaiseAmount = salaryRaiseAmount;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }
}
