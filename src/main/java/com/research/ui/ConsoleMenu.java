package com.research.ui;

import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== BANKING SYSTEM ===");
            System.out.println("1. Customers");
            System.out.println("2. Accounts");
            System.out.println("3. Transactions");
            System.out.println("4. Channels");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> new CustomerMenu().show();
                case 2 -> new AccountMenu().show();
                case 3 -> new TransactionMenu().show();
                case 4 -> new ChannelMenu().show();
                case 0 -> {
                    System.out.println("Goodbye 👋");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
