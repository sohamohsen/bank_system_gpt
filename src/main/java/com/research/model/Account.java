package com.research.model;

public class Account {
    private int id;
    private String accountNumber;
    private Customer customer;
    private AccountType accountType;
    private double balance;
    private AccountStatus status;

    public Account(int id, String accountNumber, Customer customer,
                   AccountType accountType, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.accountType = accountType;
        this.balance = balance;
        this.status = AccountStatus.ACTIVE;
    }

    public int getId() { return id; }
    public String getAccountNumber() { return accountNumber; }
    public Customer getCustomer() { return customer; }
    public AccountType getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public AccountStatus getStatus() { return status; }

    public void setBalance(double balance) { this.balance = balance; }
    public void setStatus(AccountStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", customer=" + customer.getFullName() +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
