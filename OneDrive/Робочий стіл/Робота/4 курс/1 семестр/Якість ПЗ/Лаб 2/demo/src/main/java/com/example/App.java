package com.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Library library = new Library();

        List<Book> books = new ArrayList<>();
        books.add(new Book("Melania", "Melania Trump ", 2024, 17.99));
        books.add(new Book("How to Catch a Turkey", "Adam Wallace and Andy Elkerton", 2018, 5.0));
        books.add(new Book("The Book of Unusual Knowledge", " Publications International Ltd.", 2012, 4.75));

        System.out.println("Sorting by Title:");
        List<Book> sortedByTitle = library.sortByTitle(new ArrayList<>(books));
        sortedByTitle.forEach(book -> System.out.println(book.getTitle()));

        System.out.println("\nSorting by Author:");
        List<Book> sortedByAuthor = library.sortByAuthor(new ArrayList<>(books));
        sortedByAuthor.forEach(book -> System.out.println(book.getAuthor()));

        System.out.println("\nSorting by Year:");
        List<Book> sortedByYear = library.sortByYear(new ArrayList<>(books));
        sortedByYear.forEach(book -> System.out.println(book.getYear()));

        System.out.println("\nSorting by Price:");
        List<Book> sortedByPrice = library.sortByPrice(new ArrayList<>(books));
        sortedByPrice.forEach(book -> System.out.println(book.getPrice()));
    }
}

