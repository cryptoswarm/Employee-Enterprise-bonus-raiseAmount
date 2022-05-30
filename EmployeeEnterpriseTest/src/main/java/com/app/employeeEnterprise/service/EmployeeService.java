package com.app.employeeEnterprise.service;

import com.app.employeeEnterprise.model.Employee;
import com.app.employeeEnterprise.model.Role;
import com.app.employeeEnterprise.repository.EmployeeRepository;
import com.app.employeeEnterprise.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional @Slf4j
public class EmployeeService implements IEmployeeService, UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;



    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String employeeRegistration) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmployeeRegistration(employeeRegistration);
        if( null == employee)
        {
            log.error("loadUserByUsername({}) method returns : Employee not found in the database",employeeRegistration);
            throw new UsernameNotFoundException("Employee not found in the database");
        }else {
            log.info("loadUserByUsername({}) method returns : employee {} {} found in the database",employeeRegistration, employee.getEmployeeLastName(), employee.getEmployeeFirstName());
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        employee.getRoles().forEach(role -> {
                authorities.add( new SimpleGrantedAuthority(role.getRoleName()));
        });

        return new User(employee.getEmployeeRegistration(), employee.getPassword(), authorities);

    }

    @Override
    public Employee saveEmployee(Employee employee) {
        log.info("Saving employee {} to the database", employee.getEmployeeFirstName());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role {} to the database", role.getRoleName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToEmployee(String employeeRegistration, String roleName) {
        Employee employee = employeeRepository.findByEmployeeRegistration(employeeRegistration);
        log.info("Adding role  {} to employee {} in the database", roleName, employee.getEmployeeLastName());
        Role role = roleRepository.findByRoleName(roleName);
        employee.getRoles().add(role);
    }

    @Override
    public Employee getEmployee(String employeeRegistration) {

        Employee employee = employeeRepository.findByEmployeeRegistration(employeeRegistration);
        log.info("Fetching employee {} from  the database", employee.getEmployeeLastName());
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        log.info("Fetching all employees from  the database");
        return employeeRepository.findAll();
    }


}
