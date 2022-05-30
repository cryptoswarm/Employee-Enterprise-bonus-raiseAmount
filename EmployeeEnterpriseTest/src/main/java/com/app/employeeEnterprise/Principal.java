package com.app.employeeEnterprise;

import com.app.employeeEnterprise.model.Employee;
import com.app.employeeEnterprise.model.Role;
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

        /*String registration;
        String lastName;
        String firstName;
        int echelon;
        double currentSalary;
        char performanceGrade;

        Message.printMsgWelcom();
        Message.printMenu();
        IExtractor extractor = new Extractor();
        ISaver saver = new Saver();
        IChecker checker = new Checker();

        IEnterprise aCompany = new Enterprise();
        extractor.readFile("employeeInfoBefore.txt", new Creator(), aCompany);
        while (true) {

            int choice = checker.checkUserChoiceInput();
            if (choice == 0) {
                Message.printQuitMsg();
                saver.saveEmployees(aCompany, "EmployeesDataAfterEdit");
                saver.displayData("EmployeesDataAfterEdit");
                break;
            } else if (choice == 1) {

                registration = checker.checkUserRegistrationNbr();
                lastName = checker.checkEmployeeName(Constante.MSG_PROMPT_EMPLOYE_LAST_NAME, Constante.MSG_ERR_EMPLOYE_LAST_NAME);
                firstName = checker.checkEmployeeName(Constante.MSG_PROMPT_EMPLOYE_FIRST_NAME, Constante.MSG_ERR_EMPLOYE_FIRST_NAME);
                echelon = checker.checkEmployeeEchelon();
                currentSalary = checker.checkEmployeeSalary();
                performanceGrade = checker.checkEmployeePerformanceGrade();

                IEmployee anEmployee = new Employee(registration, lastName, firstName, echelon, currentSalary, performanceGrade);

                anEmployee.setPerformanceDescription(BonusSalaryRaise.displayPerformanceGradeDescription(performanceGrade));

                anEmployee.setSalaryRaiseRate(BonusSalaryRaise.getRateSalaryRaise(echelon));
                anEmployee.setSalaryRaiseAmount(BonusSalaryRaise.getRateSalaryRaise(echelon));
                anEmployee.setBonusRate(BonusSalaryRaise.getBonusRate(echelon, performanceGrade));
                anEmployee.setBonus(BonusSalaryRaise.getEmployeeBonus(
                        BonusSalaryRaise.getBonusRate(echelon, performanceGrade), currentSalary));

                anEmployee.setNewSalary(BonusSalaryRaise.getNewSalary((float) anEmployee.getSalaryRaiseAmount(), currentSalary));

                anEmployee.display();

                aCompany.addEmployee(anEmployee);

            } else if (choice == 2) {
                saver.displayData("EmployeesDataAfterEdit");
            }

        }*/
    }

    @Bean //whenever the app starts this bean will be pick up
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner run(EmployeeService employeeService)
    {
        return  args -> {
            employeeService.saveRole(new Role(null, "ROLE_USER"));
            employeeService.saveRole(new Role(null, "ROLE_MANAGER"));
            employeeService.saveRole(new Role(null, "ROLE_ADMIN"));
            employeeService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            employeeService.saveEmployee(new Employee("SAFM11",
                    "SAF",
                    "mok",
                    3,
                    2000,
                    'P',
                    "safm11safm"));
            employeeService.saveEmployee(new Employee("BOUP07",
                    "BOU",
                    "pass",
                    2,
                    1200,
                    'N',
                    "boup07boup"));
            employeeService.saveEmployee(new Employee("TIBO89",
                    "TIBO",
                    "SUZ",
                    1,
                    1000,
                    'A',
                    "tib089tib"));
            employeeService.saveEmployee(new Employee("MICH19",
                    "MICH",
                    "BAMBOU",
                    1,
                    1000,
                    'P',
                    "mich19mich"));

            employeeService.addRoleToEmployee("SAFM11", "ROLE_USER");
            employeeService.addRoleToEmployee("SAFM11", "ROLE_MANAGER");
            employeeService.addRoleToEmployee("SAFM11", "ROLE_ADMIN");
            employeeService.addRoleToEmployee("SAFM11", "ROLE_SUPER_ADMIN");

            employeeService.addRoleToEmployee("BOUP07", "ROLE_USER");

            employeeService.addRoleToEmployee("TIBO89", "ROLE_USER");
            employeeService.addRoleToEmployee("TIBO89", "ROLE_MANAGER");

            employeeService.addRoleToEmployee("MICH19", "ROLE_USER");
            employeeService.addRoleToEmployee("MICH19", "ROLE_ADMIN");
        };
    }
}
