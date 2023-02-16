package com.app.employeeEnterprise.repository;

import com.app.employeeEnterprise.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmployeeId(Long id);
}
