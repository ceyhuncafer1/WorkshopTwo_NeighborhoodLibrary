package com.ps;

import java.util.Scanner;

public class Main {
    private static final int MAX_BOOKS = 20;
    private static Book[] inventory = new Book[MAX_BOOKS];
    private static int bookCount = 0;

    public static void main(String[] args) {
        addBook(new Book(1, "11111", "Harry Potter and the Sorcerer's Stone"));
        addBook(new Book(2, "11112", "Harry Potter and the Order of the Phoenix"));
        addBook(new Book(2, "11113", "Harry potter and the Chamber of Secrets"));
    }

    //TO DO - showHomeScreen(), then showAvailableBooks(), then showCheckedOutBooks, then checkInBook()

    public static void addBook(Book book) {
        if (bookCount < MAX_BOOKS) {
            inventory[bookCount++] = book;
        } else {
            System.out.println("Max books reached");
        }
    }

    public static void showHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\nWelcome to Neighborhood Library!");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //showAvailableBooks();
                    break;
                case 2:
                    //showCheckedOutBooks();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!exit);

        System.out.println("Thank you for using Neighborhood Library. Goodbye!");
    }
}