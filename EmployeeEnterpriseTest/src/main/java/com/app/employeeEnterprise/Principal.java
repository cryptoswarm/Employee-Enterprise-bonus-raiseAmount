package com.app.employeeEnterprise;

import com.app.employeeEnterprise.dtos.RoleDto;
import com.app.employeeEnterprise.model.Account;
import com.app.employeeEnterprise.model.Employee;
import com.app.employeeEnterprise.service.AccountService;
import com.app.employeeEnterprise.service.EmployeeService;
import com.app.employeeEnterprise.service.RoleService;
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
    CommandLineRunner run(EmployeeService employeeService,
                          RoleService roleService,
                          AccountService accountService)
    {
        return  args -> {
            roleService.saveRole(new RoleDto(null, "ROLE_USER"));
            roleService.saveRole(new RoleDto(null, "ROLE_MANAGER"));
            roleService.saveRole(new RoleDto(null, "ROLE_ADMIN"));
            roleService.saveRole(new RoleDto(null, "ROLE_SUPER_ADMIN"));

            employeeService.saveEmployee(new Employee(
                    "safir",
                    "mokhtar",
                    "safm1"));
            employeeService.saveEmployee(new Employee(
                    "MICH",
                    "BAMBOU",
                "micb1"));

            employeeService.addRoleToEmployee("safm1", "ROLE_USER");
            employeeService.addRoleToEmployee("safm1", "ROLE_MANAGER");
            employeeService.addRoleToEmployee("safm1", "ROLE_ADMIN");
            employeeService.addRoleToEmployee("safm1", "ROLE_SUPER_ADMIN");

            employeeService.addRoleToEmployee("micb1", "ROLE_USER");

            employeeService.addRoleToEmployee("micb1", "ROLE_USER");
            employeeService.addRoleToEmployee("micb1", "ROLE_MANAGER");

            employeeService.addRoleToEmployee("micb1", "ROLE_USER");
            employeeService.addRoleToEmployee("micb1", "ROLE_ADMIN");

            var employee1 = employeeService.getEmployee("safm1");
            accountService.saveAccount(new Account(employee1.getId(), employee1.getRegistration()));

            var employee2 = employeeService.getEmployee("micb1");
            accountService.saveAccount(new Account(employee2.getId(), employee2.getRegistration()));

        };
    }
}


//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Principal {
//
//    public static int[] count(String[] words){
//         return Arrays.stream(words).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
//                        .values()
//                        .stream()
//                        .mapToInt(Long::intValue).toArray();
//    }
//    public static  void main (String[] args){
//
//        int[] results = count(new String[]{"one", "two", "three", "four", "one"});
//        for (int v: results) {
//            System.out.println(v);
//        }
//    }
//}