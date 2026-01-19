package com.research.ui;

import com.research.model.Account;
import com.research.model.AccountType;
import com.research.model.Customer;
import com.research.repository.AccountRepository;
import com.research.service.AccountService;
import com.research.service.ValidationService;

import java.util.Scanner;

public class AccountMenu {

    private final AccountService service =
            new AccountService(new AccountRepository(), new ValidationService());
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        System.out.println("1. Create Account");
        System.out.println("2. View Accounts");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Account ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Account Number: ");
            String number = scanner.nextLine();

            Customer dummyCustomer =
                    new Customer(1, "Demo", "demo@mail.com", "000");

            AccountType type =
                    new AccountType(1, "SAVINGS", "Savings Account");

            service.createAccount(
                    new Account(id, number, dummyCustomer, type, 0)
            );
        } else {
            service.getAll().forEach(System.out::println);
        }
    }
}
