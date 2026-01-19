package com.research.model;

import com.research.model.Account;
import com.research.model.TransactionStatus;
import com.research.model.TransactionType;

import java.time.LocalDateTime;

public class Transaction {

    private int id;
    private Account account;
    private TransactionChannel channel;
    private TransactionType type;
    private double amount;
    private TransactionStatus status;
    private LocalDateTime transactionTime;

    public Transaction(int id,
                       Account account,
                       TransactionChannel channel,
                       TransactionType type,
                       double amount,
                       TransactionStatus status,
                       LocalDateTime transactionTime) {

        this.id = id;
        this.account = account;
        this.channel = channel;
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.transactionTime = transactionTime;
    }

    // ---------- Getters ----------
    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public TransactionChannel getChannel() {
        return channel;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    // ---------- Setters ----------
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    // ---------- Business Helper Methods ----------
    public boolean isPending() {
        return status == TransactionStatus.PENDING;
    }

    public boolean isApproved() {
        return status == TransactionStatus.APPROVED;
    }

    public boolean isCompleted() {
        return status == TransactionStatus.COMPLETED;
    }

    // ---------- toString ----------
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", account=" + account.getAccountNumber() +
                ", channel=" + channel.getName() +
                ", type=" + type +
                ", amount=" + amount +
                ", status=" + status +
                ", time=" + transactionTime +
                '}';
    }
}
