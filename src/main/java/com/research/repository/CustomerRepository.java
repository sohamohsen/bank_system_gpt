package com.research.repository;

import com.research.model.Customer;

public class CustomerRepository extends InMemoryBaseRepository<Customer> {

    @Override
    protected int getId(Customer entity) {
        return entity.getId();
    }
}
