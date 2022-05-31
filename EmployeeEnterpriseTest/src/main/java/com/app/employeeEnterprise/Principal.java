package com.app.employeeEnterprise;

import com.app.employeeEnterprise.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Principal {

    public static void main(String[] args) {
        SpringApplication.run(Principal.class, args);
    }

    @Bean //whenever the app starts this bean will be pick up
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(EmployeeService employeeService)
    {
        return  args -> {
//            employeeService.saveRole(new Role(null, "ROLE_USER"));
//            employeeService.saveRole(new Role(null, "ROLE_MANAGER"));
//            employeeService.saveRole(new Role(null, "ROLE_ADMIN"));
//            employeeService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

//            employeeService.saveEmployee(new Employee("SAFM14",
//                    "SAFMOK",
//                    "mokSAF",
//                    3,
//                    2000,
//                    'P',
//                    "safm11safm"));
//            employeeService.saveEmployee(new Employee("BOUP07",
//                    "BOU",
//                    "pass",
//                    2,
//                    1200,
//                    'N',
//                    "boup07boup"));
//            employeeService.saveEmployee(new Employee("TIBO89",
//                    "TIBO",
//                    "SUZ",
//                    1,
//                    1000,
//                    'A',
//                    "tib089tib"));
//            employeeService.saveEmployee(new Employee("MICH19",
//                    "MICH",
//                    "BAMBOU",
//                    1,
//                    1000,
//                    'P',
//                    "mich19mich"));

//            employeeService.addRoleToEmployee("SAFM14", "ROLE_USER");
//            employeeService.addRoleToEmployee("SAFM11", "ROLE_MANAGER");
//            employeeService.addRoleToEmployee("SAFM11", "ROLE_ADMIN");
//            employeeService.addRoleToEmployee("SAFM11", "ROLE_SUPER_ADMIN");
//
//            employeeService.addRoleToEmployee("BOUP07", "ROLE_USER");
//
//            employeeService.addRoleToEmployee("TIBO89", "ROLE_USER");
//            employeeService.addRoleToEmployee("TIBO89", "ROLE_MANAGER");
//
//            employeeService.addRoleToEmployee("MICH19", "ROLE_USER");
//            employeeService.addRoleToEmployee("MICH19", "ROLE_ADMIN");
        };
    }
}
