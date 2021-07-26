package writer;

import employee.IEmployee;
import enterprise.IEnterprise;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Saver implements ISaver{


    @Override
    public void saveEmployees(IEnterprise enterprise) {

        try {
            //PrintWriter fwrite = new PrintWriter("EmployeesDataAfterEdit");
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("EmployeesDataAfterEdit", true), StandardCharsets.UTF_8));

            for (IEmployee employee : enterprise.getEmployees()) {

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

    public void displayData(IEnterprise enterprise)
    {
        for(IEmployee employee: enterprise.getEmployees()){
            System.out.println(employee);
        }
    }
}
