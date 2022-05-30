package com.app.employeeEnterprise.helpers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Checker implements IChecker {

    /**
     * Ask for employe registration
     * Check employe registration
     * @return Employe registration number
     */
    public  String checkUserRegistrationNbr(){
        String registration = "";
        boolean isValid ;
        do{
            isValid = true;
            System.out.print( Constante.MSG_PROMPT_USER_REGISTRATION_NBR );
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
                System.out.println(Constante.MSG_ERR_PROMPT_USER_REGISTRATION_NBR);
            }
        }while(!isValid);
        return registration;
    }

    /**
     * Ask for employe last and first name
     * Check employe last and first name
     * @return last or first name
     */
    public  String checkEmployeeName(String askMsg, String errMsg){
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
    public  int checkEmployeeEchelon(){
        int employeeEchelon = 0;
        boolean isValid;
        do{
            isValid = true;
            System.out.print(Constante.MSG_PROMPT_EMPLOYEE_ECHELON);
            try {
                Scanner sc = new Scanner(System.in);
                employeeEchelon = sc.nextInt();
                if(employeeEchelon < 1 || employeeEchelon > 3){
                    System.out.println(Constante.MSG_ERR_EMPLOYEE_ECHELON);
                    isValid = false;
                }
            }catch(InputMismatchException e){
                System.out.println(Constante.MSG_ERR_EMPLOYEE_ECHELON);
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
    public  double checkEmployeeSalary(){
        double employeeSalary = 0.0;
        boolean isValid;
        do{
            isValid = true;
            System.out.print(Constante.MSG_PROMPT_EMPLOYE_SALARY);
            try{
                Scanner sc = new Scanner(System.in);
                employeeSalary = sc.nextDouble();
                if(employeeSalary <= 0 ){
                    System.out.println(Constante.MSG_ERR_EMPLOYE_SALARY);
                    isValid = false;
                }
            }catch(InputMismatchException e){
                System.out.println(Constante.MSG_ERR_EMPLOYE_SALARY);
                isValid = false;
            }
        }while(!isValid);
        return employeeSalary;
    }
    public  char checkEmployeePerformanceGrade(){
        char performanceGrade='X';
        boolean isValid;
        do{
            isValid = true;
            System.out.print(Constante.MSG_PROMPT_EMPLOYEE_PERFORMANCE_GRADE);
            Scanner sc = new Scanner(System.in);
            performanceGrade = sc.nextLine().charAt(0);
            if(!Character.isLetter(performanceGrade)){
                System.out.println(Constante.MSG_ERR_EMPLOYEE_PERFORMANCE_GRADE);
                isValid = false;
            }else if(performanceGrade !='D' && performanceGrade !='A' && performanceGrade !='P' && performanceGrade !='N'){
                System.out.println(Constante.MSG_ERR_EMPLOYEE_PERFORMANCE_GRADE);
                isValid = false;
            }

        }while(!isValid);
        return  performanceGrade;
    }

    /**
     * Ask for user choice from main menu.
     * Check if choice is valid.
     * @return user main menu choice.
     */
    public  int checkUserChoiceInput(){
        int input = 0;
        boolean isValid ;
        do {
            isValid = true;
            System.out.print(Constante.MSG_PROMPT_MENU_CHOICE);
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                if (input != 0 && input != 1 && input != 2 && input != 3) {
                    System.out.print(Constante.MSG_ERR_USER_INPUT_MENU_CHOICE);
                    isValid = false;
                }
            }catch (InputMismatchException e ){
                System.out.print(Constante.MSG_ERR_USER_INPUT_MENU_CHOICE);
                isValid = false;
            }
        } while (!isValid);
        return input;
    }

}
