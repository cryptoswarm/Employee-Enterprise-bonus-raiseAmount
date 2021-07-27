package enterprise;

import employee.IEmployee;

import java.util.ArrayList;

public interface IEnterprise {

    void addEmployee(IEmployee anEmployee);
    ArrayList<IEmployee> getEmployees();
}
