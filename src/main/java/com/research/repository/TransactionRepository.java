package com.research.repository;

import com.research.model.Transaction;

public class TransactionRepository extends InMemoryBaseRepository<Transaction> {

    @Override
    protected int getId(Transaction entity) {
        return entity.getId();
    }
}
