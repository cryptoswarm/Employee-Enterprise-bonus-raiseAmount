package reader;

import calculator.BonusSalaryRaise;
import employee.Employee;
import employee.IEmployee;
import enterprise.Enterprise;
import enterprise.IEnterprise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Extractor implements IExtractor {

    private final IEnterprise enterprise = new Enterprise();
    private IEmployee employee;

    @Override
    public void readFile() {

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

                employee = new Employee(registration, lastName, firstName, echelon, currentSalary, performanceGrade);

                employee.setPerformanceDescription(BonusSalaryRaise.displayPerformanceGradeDescription(performanceGrade));
                float bonusRate = BonusSalaryRaise.getBonusRate(echelon, performanceGrade);
                employee.setBonusRate(bonusRate);
                employee.setBonus(BonusSalaryRaise.getEmployeeBonus(bonusRate, currentSalary));
                employee.setSalaryRaiseRate(BonusSalaryRaise.getRateSalaryRaise(echelon));
                employee.setSalaryRaiseAmount(BonusSalaryRaise.getNewSalary(employee.getSalaryRaiseRate(), currentSalary));
                employee.setNewSalary(BonusSalaryRaise.getNewSalary(employee.getSalaryRaiseRate(), currentSalary ));

                enterprise.addEmployee(employee);
            }
            fr.close();
            rd.close();

        }catch(FileNotFoundException e){
            System.out.println("file does not exit!");
        }catch(IOException e){
            System.out.println("Error input output");

        }

    }
}
