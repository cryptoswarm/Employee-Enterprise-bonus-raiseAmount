package calculator;

public class BonusSalaryRaise {

    public static String displayPerformanceGradeDescription( char performanceGrade){
        String performanceDescription = "";
        switch ( performanceGrade ){
            case 'A' :
                performanceDescription = "Condition fairlly Satisfied";
                break;
            case 'P':
                performanceDescription = "Condition partially Satisfied";
                break;
            case 'D':
                performanceDescription = "Condition satisfied";
                break;
            case 'N':
                performanceDescription = "Not satisfied";
                break;
        }
        return performanceDescription;
    }

    /**
     * Find the employee bonus rate based on employee's echelon and performanceGrade
     * @param echelon
     * @param performanceGrade
     * @return employee bonus rate
     */
    public static float getBonusRate( int echelon, char performanceGrade){
        float bonusRate =0.0f;

        switch (performanceGrade) {
            case 'D':
                switch (echelon) {
                    case 1:
                        bonusRate = 7.5f;
                        break;
                    case 2:
                        bonusRate = 10.0f;
                        break;
                    case 3:
                        bonusRate = 15.0f;
                }
                break;
            case 'A':
                switch (echelon) {
                    case 1:
                        bonusRate = 5.0f;
                        break;
                    case 2:
                        bonusRate = 7.5f;
                        break;
                    case 3:
                        bonusRate = 10.0f;
                }
                break;
            case 'P':
                switch (echelon) {
                    case 1:
                        bonusRate = 3.0f;
                        break;
                    case 2:
                        bonusRate = 5.0f;
                        break;
                    case 3:
                        bonusRate = 7.5f;
                }
                break;
            case 'N':
                bonusRate = 0.0f;
        }
        return bonusRate;

    }

    /**
     * Find salary rate raise of an employee base on employee's echelon
     * @param echelon
     * @return salary rate raise
     */

    public static float getRateSalaryRaise(int echelon){
        float salaryRateRaise = 0.0f;
        switch (echelon) {
            case 1:
                salaryRateRaise = 2.5f;
                break;
            case 2:
                salaryRateRaise = 2.75f;
                break;
            case 3:
                salaryRateRaise = 3.0f;
                break;
        }
        return salaryRateRaise;

    }

    /**
     * Calculate employe bonus based on bonusRate and salary
     * @param bonusRate
     * @param oldSalary
     * @return
     */
    public static double getEmployeeBonus( float bonusRate, double oldSalary){

        return ( bonusRate/100 ) * oldSalary;
    }

    /**
     * Calculate the new salary  of an employee
     * adding the amount raise based on salary rate raise and salary to the old salary
     * @param salaryRateRaise
     * @param oldSalary
     * @return  new salary without bonus
     */
    public static double getNewSalary( float salaryRateRaise, double oldSalary){
        return ( (salaryRateRaise / 100) * oldSalary ) + oldSalary;
    }

}
