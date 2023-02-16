package com.app.employeeEnterprise.service;

import com.app.employeeEnterprise.logging.SL4JLogger;
import com.app.employeeEnterprise.model.Account;
import com.app.employeeEnterprise.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AccountService implements IAccountService{


    private final IAccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AccountService(IAccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Account> findByEmployeeId(Long employeeId) {
        return this.accountRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Account saveAccount(Account account) {
        SL4JLogger.getLogger().info("Saving account for user {} ", account.getEmployeeId());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }
}
