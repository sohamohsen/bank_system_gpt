package com.research.service;

import com.research.exception.BusinessRuleViolationException;
import com.research.model.*;
import com.research.repository.TransactionRepository;
import com.research.service.AccountService;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionService {

    private final TransactionRepository repository;
    private final AccountService accountService;

    public TransactionService(TransactionRepository repository,
                              AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }

    public Transaction createTransaction(Account account,
                                         TransactionChannel channel,
                                         TransactionType type,
                                         double amount) {

        accountService.validateActive(account);

        if (amount <= 0) {
            throw new BusinessRuleViolationException("Amount must be positive");
        }

        Transaction tx = new Transaction(
                repository.findAll().size() + 1,
                account,
                channel,
                type,
                amount,
                TransactionStatus.PENDING,
                LocalDateTime.now()
        );

        repository.save(tx);
        return tx;
    }

    public void approve(Transaction tx) {
        if (tx.getType() == TransactionType.WITHDRAW &&
                tx.getAccount().getBalance() < tx.getAmount()) {
            tx.setStatus(TransactionStatus.DENIED);
            throw new BusinessRuleViolationException("Insufficient balance");
        }

        if (tx.getType() == TransactionType.DEPOSIT) {
            tx.getAccount().setBalance(
                    tx.getAccount().getBalance() + tx.getAmount()
            );
        }

        if (tx.getType() == TransactionType.WITHDRAW) {
            tx.getAccount().setBalance(
                    tx.getAccount().getBalance() - tx.getAmount()
            );
        }

        tx.setStatus(TransactionStatus.COMPLETED);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }
}
