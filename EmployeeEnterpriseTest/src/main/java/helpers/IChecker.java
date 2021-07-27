package helpers;

public interface IChecker {

    String checkUserRegistrationNbr();
    String checkEmployeeName(String askMsg, String errMsg);
    int checkEmployeeEchelon();
    double checkEmployeeSalary();
    char checkEmployeePerformanceGrade();
    int checkUserChoiceInput();

}
