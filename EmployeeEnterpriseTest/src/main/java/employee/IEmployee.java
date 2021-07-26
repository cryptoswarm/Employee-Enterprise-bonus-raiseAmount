package employee;

public interface IEmployee {

     String getEmployeeRegistration();

    String getEmployeeLastName();

    String getEmployeeFirstName();

    int getEmployeeEchelon() ;

    double getEmployeeOldSalary() ;

    char getPerformanceGrade() ;

    String getPerformanceDescription() ;

    float getBonusRate();

    double getBonus();

    float getSalaryRaiseRate();

    double getSalaryRaiseAmount() ;

    double getNewSalary();

    void setPerformanceDescription(String performanceDescription);

    void setBonusRate(float bonusRate);

    void setBonus(double bonus);

    void setSalaryRaiseRate(float salaryRaiseRate);

    void setSalaryRaiseAmount(double salaryRaiseAmount);

    void setNewSalary(double newSalary);

    String toString();

    void display();
}
