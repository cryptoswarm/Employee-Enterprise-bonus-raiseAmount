package main;

public class Employee {
    /**
     * Pour chaque employé, vous devez afficher les informations dans l’ordre suivant
     * sur une seule ligne avec une barre oblique (|) comme séparateur :



     * le taux de l’augmentation de salaire,
     * l'augmentation de salaire
     * et le salaire après augmentation.
     */
    private  String employeeRegistration;
    private String employeeLastName;
    private String employeeFirstName;
    private int employeeEchelon;
    private double employeeOldSalary;
    private char performanceGrade;
    private String performanceDescription;
    private float bonusRate;
    private double bonus;
    private float salaryRaiseRate;
    private double salaryRaiseAmount;
    private double newSalary;

    public Employee( String employeeRegistration, String employeeLastName, String employeeFirstName,
                     int employeeEchelon, double employeeOldSalary, char performanceGrade){
        this.employeeRegistration = employeeRegistration;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.employeeEchelon = employeeEchelon;
        this.employeeOldSalary = employeeOldSalary;
        this.performanceGrade = performanceGrade;

    }

    public String getEmployeeRegistration(){
        return employeeRegistration;
    }

    public String getEmployeeLastName(){
        return employeeLastName;
    }
    public String getEmployeeFirstName(){
        return employeeFirstName;
    }

    public int getEmployeeEchelon(){
        return employeeEchelon;
    }

    public double getEmployeeOldSalary(){
        return employeeOldSalary;
    }

    public char getPerformanceGrade(){
        return performanceGrade;
    }

    public String getPerformanceDescription(){
        return performanceDescription;
    }

    public float getBonusRate(){
        return bonusRate;
    }

    public double getBonus(){
        return bonus;
    }

    public float getSalaryRaiseRate(){
        return salaryRaiseRate;
    }
    public double getSalaryRaiseAmount(){
        return salaryRaiseAmount;
    }
    public double getNewSalary(){
        return newSalary;
    }

    public void setPerformanceDescription(String performanceDescription){
        this.performanceDescription = performanceDescription;
    }
    public void setBonusRate(float bonusRate){
        this.bonusRate = bonusRate;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public void setSalaryRaiseRate(float salaryRaiseRate){
        this.salaryRaiseRate = salaryRaiseRate;
    }

    public void setSalaryRaiseAmount(double salaryRaiseAmount){
        this.salaryRaiseAmount = salaryRaiseAmount;
    }
    public void setNewSalary(double newSalary){
        this.newSalary = newSalary;
    }

    public  String toString(){
        return String.format("|%s|%s %s| %d| %6.2f | %s | %2.1f | %5.2f | %1.1f | %5.2f | %6.2f |", employeeRegistration,
                employeeLastName, employeeFirstName, employeeEchelon,  employeeOldSalary,
                performanceDescription, bonusRate, bonus, salaryRaiseRate, salaryRaiseAmount, newSalary );

    }

    public void display() {
        System.out.printf("Employee registration : %s\n", employeeRegistration);
        System.out.printf("Employee last and first name  : %s %s\n",employeeLastName, employeeFirstName);
        System.out.printf("Employee Echelon : %d \n",employeeEchelon);
        System.out.printf("Employee old salary  : %6.2f\n", employeeOldSalary);
        System.out.printf("Employee performance description : %s\n", performanceDescription);
        System.out.printf("Employee bonus rate : %2.2f\n", bonusRate);
        System.out.printf("Employee bonus : %2.2f\n",bonus);
        System.out.printf("Employee raise rate  : %2.2f\n", salaryRaiseRate);
        System.out.printf("Employee salary raise amount  : %6.2f\n", salaryRaiseAmount);
        System.out.printf("Employee new salary without bonus : %6.2f\n", newSalary);

    }

}

