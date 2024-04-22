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
}