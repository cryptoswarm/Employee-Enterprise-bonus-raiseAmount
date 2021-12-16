package com.app.employeeEnterprise.writer;

import com.app.employeeEnterprise.enterprise.IEnterprise;

public interface ISaver {

    void saveEmployees(IEnterprise enterprise, String dataDestination);
    void displayData(String dataSource);
}
