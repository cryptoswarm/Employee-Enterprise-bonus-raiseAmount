package com.app.employeeEnterprise.repository;

import com.app.employeeEnterprise.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByRegistration(String registration);
}
