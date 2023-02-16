package com.app.employeeEnterprise.service;

import com.app.employeeEnterprise.model.Account;
import com.app.employeeEnterprise.model.Employee;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByEmployeeId(Long id);

    Account saveAccount(Account account);
}
