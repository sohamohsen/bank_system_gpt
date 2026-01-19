package com.research.service;

import com.research.exception.NotFoundException;
import com.research.model.Customer;
import com.research.repository.CustomerRepository;

import java.util.List;

public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public void addCustomer(Customer customer) {
        repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
    }

    public void deleteCustomer(int id) {
        repository.delete(id);
    }
}
