package Main;

import calculator.BonusSalaryRaise;
import employee.Employee;
import employee.IEmployee;
import enterprise.Enterprise;
import reader.Extractor;
import reader.IExtractor;
import writer.ISaver;
import writer.Saver;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    final static String MSG_WELCOME = "Welcome in Entrprise Employe App.\n The app will help you calculate bonus and salary";
    final static String MSG_QUIT = "Thank you for using this app.";
    final static String MAIN_MENU = "0. Quit\n"+
            "1. Salary and bonus raise estimation \n"+
            //"2. Salary raise estimation\n"+
            "2. Display all employees\n";
    final static String MSG_PROMPT_MENU_CHOICE = "What is your choice ? Please enter either 0, 1, or 2 : ";
    final static String MSG_ERR_USER_INPUT_MENU_CHOICE = "Wrong menu choice! Please enter either 0, 1, 2 or 3 : ";
    final static String MSG_PROMPT_USER_REGISTRATION_NBR = "Enter your REGISTRATION nbr respecting the following format\n" +
            "A valid registration number : abcd12 or ABCD12 : ";
    final static String MSG_ERR_PROMPT_USER_REGISTRATION_NBR = "Wrong registration nbr!";
    final static String MSG_PROMPT_EMPLOYE_LAST_NAME = "Enter your last name : ";
    final static String MSG_ERR_EMPLOYE_LAST_NAME = "Employe last name is invalid!";
    final static String MSG_PROMPT_EMPLOYE_FIRST_NAME = "Enter your first name :";
    final static String MSG_ERR_EMPLOYE_FIRST_NAME = "Employe first name is invalid!";
    final static String MSG_PROMPT_EMPLOYEE_ECHELON = "Enter employee echelon. 1, 2 or 3 : ";
    final static String MSG_ERR_EMPLOYEE_ECHELON = "Invalid employee echelon";
    final static String MSG_PROMPT_EMPLOYE_SALARY = "Enter employe salary : ";
    final static String MSG_ERR_EMPLOYE_SALARY = "Employe salary is invalid! Should be superieur than 0";
    final static String MSG_PROMPT_EMPLOYEE_PERFORMANCE_GRADE = "Enter employee performance grade. Should be D, A, P, or N : ";
    final static String MSG_ERR_EMPLOYEE_PERFORMANCE_GRADE = "Employee performance grade is invalid";

    /**
     * Print welcom msg
     */
    public static void printMsgWelcom(){
        System.out.println(MSG_WELCOME);
    }

    public static void printQuitMsg(){
        System.out.println(MSG_QUIT);
    }
    /**
     * Affichage du menu de choix
     */
    public static void  printMenu(){
        System.out.println(MAIN_MENU);
    }

    /**
     * Ask for user choice from main menu.
     * Check if choice is valid.
     * @return user main menu choice.
     */
    public static int checkUserChoiceInput(){
        int input = 0;
        boolean isValid ;
        do {
            isValid = true;
            System.out.print(MSG_PROMPT_MENU_CHOICE);
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                if (input != 0 && input != 1 && input != 2 && input != 3) {
                    System.out.print(MSG_ERR_USER_INPUT_MENU_CHOICE);
                    isValid = false;
                }
            }catch (InputMismatchException e ){
                System.out.print(MSG_ERR_USER_INPUT_MENU_CHOICE);
                isValid = false;
            }
        } while (!isValid);
        return input;
    }

    /**
     * Ask for employe registration
     * Check employe registration
     * @return Employe registration number
     */
    public static String checkUserRegistrationNbr(){
        String registration = "";
        boolean isValid ;
        do{
            isValid = true;
            System.out.print( MSG_PROMPT_USER_REGISTRATION_NBR );
            Scanner sc = new Scanner(System.in);
            registration = sc.nextLine().toLowerCase();

            if( registration.length() != 6 ) {
                isValid = false;
            }else{
                for(int i=0; i< registration.length() ; i++){
                    if(!Character.isLetter( registration.charAt(i) ) && i < 4 ){
                        isValid = false;
                        break;
                    }
                    if(Character.isLetter( registration.charAt(i) ) && i >= 4){
                        isValid = false;
                        break;
                    }
                }
            }
            if(!isValid){
                System.out.println(MSG_ERR_PROMPT_USER_REGISTRATION_NBR);
            }
        }while(!isValid);
        return registration;
    }

    /**
     * Ask for employe last and first name
     * Check employe last and first name
     * @return last or first name
     */
    public static String checkEmployeeName(String askMsg, String errMsg){
        String lastName;
        boolean isValid;
        do{
            isValid = true;
            System.out.print( askMsg );
            Scanner sc = new Scanner(System.in);
            lastName = sc.nextLine();
            if(lastName.length() <2 ||  lastName.length() > 30){
                isValid = false;
            }else{
                for(int i=0; i<lastName.length(); i++){
                    if( !Character.isLetter(lastName.charAt(i)) ){
                        isValid = false;
                        break;
                    }
                }
            }
            if(!isValid){
                System.out.println(errMsg);
            }
        }while(!isValid);
        return  lastName;
    }

    /**
     * Ask for employee echelon
     * Check employee echelon is valid
     * @return employee echelon
     */
    public static int checkEmployeeEchelon(){
        int employeeEchelon = 0;
        boolean isValid;
        do{
            isValid = true;
            System.out.print(MSG_PROMPT_EMPLOYEE_ECHELON);
            try {
                Scanner sc = new Scanner(System.in);
                employeeEchelon = sc.nextInt();
                if(employeeEchelon < 1 || employeeEchelon > 3){
                    System.out.println(MSG_ERR_EMPLOYEE_ECHELON);
                    isValid = false;
                }
            }catch(InputMismatchException e){
                System.out.println(MSG_ERR_EMPLOYEE_ECHELON);
                isValid = false;
            }
        }while(!isValid);
        return  employeeEchelon;
    }

    /**
     * Ask for employee salary
     * Check employee salary
     * @return
     */
    public static double checkEmployeeSalary(){
        double employeeSalary = 0.0;
        boolean isValid;
        do{
            isValid = true;
            System.out.print(MSG_PROMPT_EMPLOYE_SALARY);
            try{
                Scanner sc = new Scanner(System.in);
                employeeSalary = sc.nextDouble();
                if(employeeSalary <= 0 ){
                    System.out.println(MSG_ERR_EMPLOYE_SALARY);
                    isValid = false;
                }
            }catch(InputMismatchException e){
                System.out.println(MSG_ERR_EMPLOYE_SALARY);
                isValid = false;
            }
        }while(!isValid);
        return employeeSalary;
    }
    public static char checkEmployeePerformanceGrade(){
        char performanceGrade='X';
        boolean isValid;
        do{
            isValid = true;
            System.out.print(MSG_PROMPT_EMPLOYEE_PERFORMANCE_GRADE);
            Scanner sc = new Scanner(System.in);
            performanceGrade = sc.nextLine().charAt(0);
            if(!Character.isLetter(performanceGrade)){
                System.out.println(MSG_ERR_EMPLOYEE_PERFORMANCE_GRADE);
                isValid = false;
            }else if(performanceGrade !='D' && performanceGrade !='A' && performanceGrade !='P' && performanceGrade !='N'){
                System.out.println(MSG_ERR_EMPLOYEE_PERFORMANCE_GRADE);
                isValid = false;
            }

        }while(!isValid);
        return  performanceGrade;
    }

    public static void main(String[] args) {
        String registration;
        String lastName;
        String firstName;
        int echelon;
        double currentSalary;
        char performanceGrade;
        double bonus;
        double salaryRaiseAmount;

        printMsgWelcom();
        printMenu();
        IExtractor extractor = new Extractor();
        ISaver saver = new Saver();

        Enterprise aCompany = new Enterprise();
        extractor.readFile();
        while (true) {

            int choice = checkUserChoiceInput();
            if (choice == 0) {
                printQuitMsg();
                saver.saveEmployees(aCompany);
                break;
            } else if (choice == 1) {

                registration = checkUserRegistrationNbr();
                lastName = checkEmployeeName(MSG_PROMPT_EMPLOYE_LAST_NAME, MSG_ERR_EMPLOYE_LAST_NAME);
                firstName = checkEmployeeName(MSG_PROMPT_EMPLOYE_FIRST_NAME, MSG_ERR_EMPLOYE_FIRST_NAME);
                echelon = checkEmployeeEchelon();
                currentSalary = checkEmployeeSalary();
                performanceGrade = checkEmployeePerformanceGrade();

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
                saver.displayData(aCompany);
            }

        }
    }

}
