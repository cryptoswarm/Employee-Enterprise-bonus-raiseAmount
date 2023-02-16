package com.app.employeeEnterprise.exceptions;

public class UserAccountNotFoundException extends Exception{
    public String message;
    public UserAccountNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
