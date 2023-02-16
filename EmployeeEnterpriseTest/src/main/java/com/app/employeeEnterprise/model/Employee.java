package com.app.employeeEnterprise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //specify how to generate the id
    private Long id; //map the id as a primary key
    private String registration;
    private String firstName;
    private String lastName;

    public Employee() {
    }

    public Employee(String firstName,
                    String lastName,
                    String registration){

        this.lastName = lastName;
        this.firstName = firstName;
        this.registration = registration;
    }

    @ManyToMany(fetch = FetchType.EAGER) //loading roles at the same time of loading the employee
    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public Long getId() {
        return id;
    }

    public String getRegistration() {
        return registration;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
