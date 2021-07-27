package Main;

import calculator.BonusSalaryRaise;
import employee.Employee;
import employee.IEmployee;
import enterprise.Enterprise;
import enterprise.IEnterprise;
import helpers.Checker;
import helpers.Constante;
import helpers.IChecker;
import helpers.Message;
import manger.Creator;
import reader.Extractor;
import reader.IExtractor;
import writer.ISaver;
import writer.Saver;

public class Principal {

    public static void main(String[] args) {

        String registration;
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

        }
    }

}
