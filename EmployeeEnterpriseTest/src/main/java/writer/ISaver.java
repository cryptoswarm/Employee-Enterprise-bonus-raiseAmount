package writer;

import enterprise.IEnterprise;

public interface ISaver {

    void saveEmployees(IEnterprise enterprise, String dataDestination);
    void displayData(String dataSource);
}
