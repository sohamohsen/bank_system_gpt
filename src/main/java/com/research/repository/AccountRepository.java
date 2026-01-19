package com.research.repository;

import com.research.exception.DuplicateIdException;
import com.research.model.Account;

import java.util.Optional;

public class AccountRepository extends InMemoryBaseRepository<Account> {

    @Override
    protected int getId(Account entity) {
        return entity.getId();
    }

    public Optional<Account> findByAccountNumber(String accountNumber) {
        return storage.values()
                .stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst();
    }

    public void validateUniqueAccountNumber(String accountNumber) {
        if (findByAccountNumber(accountNumber).isPresent()) {
            throw new DuplicateIdException("Account number already exists");
        }
    }
}
