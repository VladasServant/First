package com.example;

import java.util.List;
import java.util.Comparator;

public class Library {

    public List<Book> sortByTitle(List<Book> books) {
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

    public List<Book> sortByAuthor(List<Book> books) {
        books.sort(Comparator.comparing(Book::getAuthor));
        return books;
    }

    public List<Book> sortByYear(List<Book> books) {
        books.sort(Comparator.comparingInt(Book::getYear));
        return books;
    }

    public List<Book> sortByPrice(List<Book> books) {
        books.sort(Comparator.comparingDouble(Book::getPrice));
        return books;
    }
}
