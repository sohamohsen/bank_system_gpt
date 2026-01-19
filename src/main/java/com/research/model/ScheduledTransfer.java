package com.research.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduledTransfer {

    private int id;
    private Account fromAccount;
    private Account toAccount;
    private double amount;
    private LocalDate transferDate;
    private LocalTime transferTime;

    public ScheduledTransfer(int id,
                             Account fromAccount,
                             Account toAccount,
                             double amount,
                             LocalDate transferDate,
                             LocalTime transferTime) {

        this.id = id;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.transferDate = transferDate;
        this.transferTime = transferTime;
    }

    // ---------- Getters ----------
    public int getId() {
        return id;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public LocalTime getTransferTime() {
        return transferTime;
    }

    // ---------- Business Helpers ----------
    public boolean isDue(LocalDate today, LocalTime now) {
        return transferDate.equals(today) && !now.isBefore(transferTime);
    }

    @Override
    public String toString() {
        return "ScheduledTransfer{" +
                "id=" + id +
                ", from=" + fromAccount.getAccountNumber() +
                ", to=" + toAccount.getAccountNumber() +
                ", amount=" + amount +
                ", date=" + transferDate +
                ", time=" + transferTime +
                '}';
    }
}
