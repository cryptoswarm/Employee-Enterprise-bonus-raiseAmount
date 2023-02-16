package com.app.employeeEnterprise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //specify how to generate the id
    private Long id; //map the id as a primary key
    private Long employeeId;
    private String employeeRegistration;
    private String password;
    private String accountStatus;

    public Account(Long employeeId, String employeeRegistration) {
        this.employeeId = employeeId;
        this.employeeRegistration = employeeRegistration;
        this.accountStatus = AccountStatus.INACTIVE.toString();
        this.password = "changeit"; //user needs to change the password on first login
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeRegistration() {
        return employeeRegistration;
    }

    public void setEmployeeRegistration(String employeeRegistration) {
        this.employeeRegistration = employeeRegistration;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
