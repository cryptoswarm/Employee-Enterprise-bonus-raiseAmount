package com.app.employeeEnterprise.controller;

import com.app.employeeEnterprise.dtos.EmployeeDto;
import com.app.employeeEnterprise.helpers.RoleToEmployee;
import com.app.employeeEnterprise.model.Employee;
import com.app.employeeEnterprise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees()
    {
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployees( @RequestBody Employee employee)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/employee/save").toUriString());
        Employee newEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.created(uri).body(newEmployee);
    }

    @PostMapping("/employees/{employeeRegistration}/roles")
    public ResponseEntity<?> addRoleToEmployee(@PathVariable String employeeRegistration, @RequestBody RoleToEmployee form)
    {
        employeeService.addRoleToEmployee(employeeRegistration, form.roleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employees/{employeeRegistration}/roles")
    public ResponseEntity<?> getEmployeeRoles(@PathVariable String employeeRegistration)
    {
        var roles = employeeService.getEmployeeRoles(employeeRegistration);
        return ResponseEntity.ok().body(roles);
    }
}
