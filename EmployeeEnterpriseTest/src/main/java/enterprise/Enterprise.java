package enterprise;

import employee.IEmployee;

import java.util.ArrayList;

public class Enterprise implements IEnterprise{

    private ArrayList<IEmployee> employees;

    public Enterprise(){
        employees = new ArrayList<>();
    }

    public  void addEmployee(IEmployee anEmployee){
        employees.add(anEmployee);
    }

    public ArrayList<IEmployee> getEmployees() {
        return employees;
    }
}
