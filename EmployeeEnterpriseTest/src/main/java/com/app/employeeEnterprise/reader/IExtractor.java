package com.app.employeeEnterprise.reader;

import com.app.employeeEnterprise.enterprise.IEnterprise;

public interface IExtractor {
    void readFile(String fileName, IEnterprise enterprise);
}
