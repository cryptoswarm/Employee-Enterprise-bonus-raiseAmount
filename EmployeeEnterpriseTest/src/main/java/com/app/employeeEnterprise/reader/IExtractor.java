package com.app.employeeEnterprise.reader;

import com.app.employeeEnterprise.enterprise.IEnterprise;
import com.app.employeeEnterprise.manager.ICreator;

public interface IExtractor {
    void readFile(String fileName, ICreator creator, IEnterprise enterprise);
}
