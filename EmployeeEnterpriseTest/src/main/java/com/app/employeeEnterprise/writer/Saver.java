package com.app.employeeEnterprise.writer;

import com.app.employeeEnterprise.model.IEmployee;
import com.app.employeeEnterprise.enterprise.IEnterprise;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Saver implements ISaver{


    @Override
    public void saveEmployees(IEnterprise enterprise, String fileName) {

        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName, true), StandardCharsets.UTF_8));

            for (IEmployee employee : enterprise.getEmployees()) {
                writer.write("\n");
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

                writer.write(String.format("|%s |%s %s| %d |%6.2f| %s |%2.1f |%6.2f |%1.1f| %5.2f |%6.2f| ",
                        registration, lastName, firstName, echelon, currentSalary, performanceDesc,
                        bonusRate, bonus, salaryRaiseRate, salaryRaiseAmount, newSalary));

            }
            writer.close();
        }catch(FileNotFoundException e){
            System.out.println("File does not exist");
        }catch (IOException e){
            System.out.println("Could not open the file");
        }

    }

    public void displayData(String fileName)
    {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader rd = new BufferedReader(fr);

            while (rd.ready()) {
                String lineRead = rd.readLine();
                String[] newEmployeeTab = lineRead.split("\\|");
                for(String key: newEmployeeTab)
                {
                    System.out.print("| "+key);
                }
                System.out.println();
            }
            fr.close();
            rd.close();
        }catch (FileNotFoundException ex)
        {
            System.out.println("File has not been found");
        }catch (IOException ex)
        {
            System.out.println("Error while opening the file");
        }
    }
}
