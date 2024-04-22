package com.ps;

import java.util.Scanner;

public class Main {
    private static final int MAX_BOOKS = 20;
    private static Book[] inventory = new Book[MAX_BOOKS];
    private static int bookCount = 0;

    public static void main(String[] args) {
        addBook(new Book(1, "11111", "Harry Potter and the Sorcerer's Stone"));
        addBook(new Book(2, "11112", "Harry Potter and the Order of the Phoenix"));
        addBook(new Book(3, "11113", "Harry Potter and the Chamber of Secrets"));
        addBook(new Book(4, "11114", "Harry Potter and the Prisoner of Azkaban"));
        addBook(new Book(5, "11115", "Harry Potter and the Goblet of Fire"));
        addBook(new Book(6, "11116", "Harry Potter and the Deathly Hollows"));
        addBook(new Book(7, "11117", "Harry Potter and the Half-Blood Prince"));
        addBook(new Book(8, "11118", "A Bright Shining Lie"));
        addBook(new Book(9, "11119", "All My Rage"));
        addBook(new Book(10, "11121", "Emma Dilemma"));
        addBook(new Book(11, "11122", "Why Does the World Exist?"));
        addBook(new Book(12, "11123", "Cinderella"));
        addBook(new Book(13, "11124", "I Love You More"));
        addBook(new Book(14, "111125", "We Are Okay"));
        addBook(new Book(15, "11126", "Just Kids"));
        addBook(new Book(16, "11127", "Owl at Home"));
        addBook(new Book(17, "11128", "Afterparties"));
        addBook(new Book(18, "11129", "Henry and Mudge and the Happy Cat"));
        addBook(new Book(19, "11130", "The Omnivore's Dielmma"));
        addBook(new Book(20, "11131", "Desire"));

        showHomeScreen();
    }

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
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!exit);

        System.out.println("Thank you for using The Neighborhood Library. Goodbye!");
    }

    public static void showAvailableBooks() {
        Scanner scanner = new Scanner(System.in);
        boolean backToHomeScreen = false;
        do {
            System.out.println("\nAvailable Books:");
            for (int i = 0; i < bookCount; i++) {
                if (!inventory[i].isCheckedOut()) {
                    System.out.println("ID: " + inventory[i].getId() + ", ISBN: " + inventory[i].getIsbn() + ", Title: " + inventory[i].getTitle());
                }
            }

            System.out.print("Enter ID of the book you want to check out (or 0 to go back): ");
            int bookId = scanner.nextInt();
            scanner.nextLine();

            if (bookId != 0) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                for (int i = 0; i < bookCount; i++) {
                    if (inventory[i].getId() == bookId && !inventory[i].isCheckedOut()) {
                        inventory[i].checkOut(name);
                        backToHomeScreen = true;
                        break;
                    }
                }
                if (!backToHomeScreen) {
                    System.out.println("Invalid book ID or book is already checked out.");
                }
            } else {
                backToHomeScreen = true;
            }
        } while (!backToHomeScreen);
    }

    public static void checkInBook() {
        Scanner scanner = new Scanner(System.in);
        boolean backToCheckedOutBooks = false;
        do {
            System.out.print("Enter ID of the book you want to check in: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < bookCount; i++) {
                if (inventory[i].getId() == bookId && inventory[i].isCheckedOut()) {
                    inventory[i].checkIn();
                    backToCheckedOutBooks = true;
                    break;
                }
            }
            if (!backToCheckedOutBooks) {
                System.out.println("Invalid book ID or book is not checked out.");
            }
        } while (!backToCheckedOutBooks);
    }

    public static void showCheckedOutBooks() {
        Scanner scanner = new Scanner(System.in);
        boolean backToHomeScreen = false;
        do {
            System.out.println("\nChecked Out Books:");
            for (int i = 0; i < bookCount; i++) {
                if (inventory[i].isCheckedOut()) {
                    System.out.println("ID: " + inventory[i].getId() + ", ISBN: " + inventory[i].getIsbn() + ", Title: " + inventory[i].getTitle() + ", Checked Out To: " + inventory[i].getCheckedOutTo());
                }
            }

            System.out.println("C - Check In a book");
            System.out.println("X - Go back to home screen");
            System.out.print("Select an option: ");
            String option = scanner.nextLine().toUpperCase();
            switch (option) {
                case "C":
                    checkInBook();
                    break;
                case "X":
                    backToHomeScreen = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (!backToHomeScreen);
    }
}