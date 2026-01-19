package com.research.service;

import com.research.exception.BusinessRuleViolationException;
import com.research.exception.NotFoundException;
import com.research.model.Account;
import com.research.model.AccountStatus;
import com.research.repository.AccountRepository;

import java.util.List;

public class AccountService {

    private final AccountRepository repository;
    private final ValidationService validation;

    public AccountService(AccountRepository repository, ValidationService validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public void createAccount(Account account) {
        repository.validateUniqueAccountNumber(account.getAccountNumber());
        repository.save(account);
    }

    public Account getByAccountNumber(String number) {
        return repository.findByAccountNumber(number)
                .orElseThrow(() -> new NotFoundException("Account not found"));
    }

    public List<Account> getAll() {
        return repository.findAll();
    }

    public void blockAccount(String number) {
        Account acc = getByAccountNumber(number);
        acc.setStatus(AccountStatus.BLOCKED);
    }

    public void unblockAccount(String number) {
        Account acc = getByAccountNumber(number);
        acc.setStatus(AccountStatus.ACTIVE);
    }

    public void validateActive(Account account) {
        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new BusinessRuleViolationException("Account is not active");
        }
    }
}
