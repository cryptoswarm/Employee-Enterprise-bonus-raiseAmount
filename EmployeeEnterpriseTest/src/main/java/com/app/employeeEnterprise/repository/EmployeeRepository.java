package com.app.employeeEnterprise.repository;

import com.app.employeeEnterprise.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeRegistration(String employeeRegistration);
}
