package com.research.model;

public class TransactionChannel {

    private int id;
    private String name; // ATM, ONLINE, BRANCH
    private int maxTransactionsPerMinute;
    private ChannelStatus status;

    // Runtime tracking (in-memory)
    private int currentTransactions;

    public TransactionChannel(int id,
                              String name,
                              int maxTransactionsPerMinute,
                              ChannelStatus status) {
        this.id = id;
        this.name = name;
        this.maxTransactionsPerMinute = maxTransactionsPerMinute;
        this.status = status;
        this.currentTransactions = 0;
    }

    // ---------- Getters ----------
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxTransactionsPerMinute() {
        return maxTransactionsPerMinute;
    }

    public ChannelStatus getStatus() {
        return status;
    }

    public int getCurrentTransactions() {
        return currentTransactions;
    }

    // ---------- Setters ----------
    public void setStatus(ChannelStatus status) {
        this.status = status;
    }

    // ---------- Business Helpers ----------
    public boolean isOpen() {
        return status == ChannelStatus.OPEN;
    }

    public boolean hasCapacity() {
        return currentTransactions < maxTransactionsPerMinute;
    }

    public void occupySlot() {
        currentTransactions++;
        if (currentTransactions >= maxTransactionsPerMinute) {
            status = ChannelStatus.BUSY;
        }
    }

    public void releaseSlot() {
        if (currentTransactions > 0) {
            currentTransactions--;
        }
        if (currentTransactions < maxTransactionsPerMinute && status == ChannelStatus.BUSY) {
            status = ChannelStatus.OPEN;
        }
    }

    @Override
    public String toString() {
        return "TransactionChannel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxPerMinute=" + maxTransactionsPerMinute +
                ", currentLoad=" + currentTransactions +
                ", status=" + status +
                '}';
    }
}
