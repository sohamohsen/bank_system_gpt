package com.research.ui;

import com.research.model.Customer;
import com.research.repository.CustomerRepository;
import com.research.service.CustomerService;

import java.util.Scanner;

public class CustomerMenu {

    private final CustomerService service =
            new CustomerService(new CustomerRepository());
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        System.out.println("1. Add Customer");
        System.out.println("2. View Customers");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            service.addCustomer(new Customer(id, name, email, phone));
        } else if (choice == 2) {
            service.getAllCustomers().forEach(System.out::println);
        }
    }
}
