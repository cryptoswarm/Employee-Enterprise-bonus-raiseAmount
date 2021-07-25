package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Enterprise {
    private ArrayList<main.Employee> employees;

    public Enterprise(){
        employees = new ArrayList<>();
    }

    public  void addEmployee(main.Employee anEmployee){
        employees.add(anEmployee);
    }


    public  void readFileOfEmployees(){

        try {
            int i;
            FileReader fr = new FileReader("employeeInfoBefore.txt");
            BufferedReader rd = new BufferedReader(fr);

            while (rd.ready()){
                String lineRead = rd.readLine();
                //each line = registration, last Name, first name, echelon, salary, performance grade ( P, D, N, or A)

                List<String> newEmployeeTab =   Arrays.asList( lineRead.split("\\|") );
                String registration = newEmployeeTab.get(0).trim();
                String lastName = newEmployeeTab.get(1).trim();
                String firstName = newEmployeeTab.get(2).trim();
                int echelon = Integer.parseInt( newEmployeeTab.get(3).trim() );
                double currentSalary = Double.parseDouble( newEmployeeTab.get(4).trim());
                char performanceGrade = newEmployeeTab.get(5).trim().charAt(0);

                main.Employee anEmployee = new main.Employee(registration, lastName, firstName, echelon, currentSalary, performanceGrade);

                anEmployee.setPerformanceDescription(main.BonusSalaryRaise.displayPerformanceGradeDescription(performanceGrade));
                float bonusRate = main.BonusSalaryRaise.getBonusRate(echelon, performanceGrade);
                anEmployee.setBonusRate(bonusRate);
                anEmployee.setBonus(main.BonusSalaryRaise.getEmployeeBonus(bonusRate, currentSalary));
                anEmployee.setSalaryRaiseRate(main.BonusSalaryRaise.getRateSalaryRaise(echelon));
                anEmployee.setSalaryRaiseAmount(main.BonusSalaryRaise.getNewSalary(anEmployee.getSalaryRaiseRate(), currentSalary));
                anEmployee.setNewSalary(main.BonusSalaryRaise.getNewSalary(anEmployee.getSalaryRaiseRate(), currentSalary ));

                addEmployee(anEmployee);
            }
            fr.close();
            rd.close();

        }catch(FileNotFoundException e){
            System.out.println("file does not exit!");
        }catch(IOException e){
            System.out.println("Error input output");

        }
    }

    public void saveEmployeesInFile(){

        try {
            PrintWriter fwrite = new PrintWriter("EmployeesDataAfterEdit");
            for (main.Employee employee : employees) {

                String registration = employee.getEmployeeRegistration();
                String lastName = employee.getEmployeeLastName();
                String firstName = employee.getEmployeeFirstName();
                int echelon = employee.getEmployeeEchelon();
                double currentSalary = employee.getNewSalary();
                String performanceDesc = employee.getPerformanceDescription();
                float bonusRate = employee.getBonusRate();
                double bonus = employee.getBonus();
                float salaryRaiseRate = employee.getSalaryRaiseRate();
                double salaryRaiseAmount = employee.getSalaryRaiseAmount();
                double newSalary = employee.getNewSalary();

                fwrite.println(String.format("|%s |%s %s| %d |%6.2f| %s |%2.1f |%6.2f |%1.1f| %5.2f |%6.2f| ",
                        registration, lastName, firstName, echelon, currentSalary, performanceDesc,
                        bonusRate, bonus, salaryRaiseRate, salaryRaiseAmount, newSalary));
            }
            fwrite.close();
        }catch(FileNotFoundException e){
            System.out.println("File does not exist");
        }
    }

    public void printAllEmployeesData(){
        for(main.Employee employee: employees){
            System.out.println(employee);
        }
    }


}
