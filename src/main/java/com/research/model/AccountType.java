package com.research.model;

public class AccountType {
    private int id;
    private String name;
    private String description;

    public AccountType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
