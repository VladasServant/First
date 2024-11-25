package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest {

    /**
     * Тест на сортування книг за назвою.
     */
    @Test
    public void testSortByTitle() {
        Library library = new Library();

        List<Book> books = new ArrayList<>();
        books.add(new Book("Melania", "Melania Trump", 2024, 17.99));
        books.add(new Book("How to Catch a Turkey", "Adam Wallace and Andy Elkerton", 2018, 5.0));
        books.add(new Book("The Book of Unusual Knowledge", "Publications International Ltd.", 2012, 4.75));

        List<Book> sortedBooks = library.sortByTitle(books);

        assertEquals("How to Catch a Turkey", sortedBooks.get(0).getTitle());
        assertEquals("Melania", sortedBooks.get(1).getTitle());
        assertEquals("The Book of Unusual Knowledge", sortedBooks.get(2).getTitle());
    }

    /**
     * Тест на сортування книг за автором.
     */
    @Test
    public void testSortByAuthor() {
        Library library = new Library();

        List<Book> books = new ArrayList<>();
        books.add(new Book("Melania", "Melania Trump", 2024, 17.99));
        books.add(new Book("How to Catch a Turkey", "Adam Wallace and Andy Elkerton", 2018, 5.0));
        books.add(new Book("The Book of Unusual Knowledge", "Publications International Ltd.", 2012, 4.75));

        List<Book> sortedBooks = library.sortByAuthor(books);

        assertEquals("Adam Wallace and Andy Elkerton", sortedBooks.get(0).getAuthor());
        assertEquals("Melania Trump", sortedBooks.get(1).getAuthor());
        assertEquals("Publications International Ltd.", sortedBooks.get(2).getAuthor());
    }

    /**
     * Тест на сортування книг за роком.
     */
    @Test
    public void testSortByYear() {
        Library library = new Library();

        List<Book> books = new ArrayList<>();
        books.add(new Book("Melania", "Melania Trump", 2024, 17.99));
        books.add(new Book("How to Catch a Turkey", "Adam Wallace and Andy Elkerton", 2018, 5.0));
        books.add(new Book("The Book of Unusual Knowledge", "Publications International Ltd.", 2012, 4.75));

        List<Book> sortedBooks = library.sortByYear(books);

        assertEquals(2012, sortedBooks.get(0).getYear());
        assertEquals(2018, sortedBooks.get(1).getYear());
        assertEquals(2024, sortedBooks.get(2).getYear());
    }

    /**
     * Тест на сортування книг за ціною.
     */
    @Test
    public void testSortByPrice() {
        Library library = new Library();

        List<Book> books = new ArrayList<>();
        books.add(new Book("Melania", "Melania Trump", 2024, 17.99));
        books.add(new Book("How to Catch a Turkey", "Adam Wallace and Andy Elkerton", 2018, 5.0));
        books.add(new Book("The Book of Unusual Knowledge", "Publications International Ltd.", 2012, 4.75));

        List<Book> sortedBooks = library.sortByPrice(books);

        assertEquals(4.75, sortedBooks.get(0).getPrice(), 0.0);
        assertEquals(5.0, sortedBooks.get(1).getPrice(), 0.0);
        assertEquals(17.99, sortedBooks.get(2).getPrice(), 0.0);
    }

    /**
     * Тест на обробку порожнього списку.
     */
    @Test
    public void testSortEmptyList() {
        Library library = new Library();

        List<Book> books = new ArrayList<>();
        List<Book> sortedBooks = library.sortByTitle(books);

        assertTrue(sortedBooks.isEmpty());
    }

    /**
     * Тест на обробку списку з однією книгою.
     */
    @Test
    public void testSortSingleBook() {
        Library library = new Library();

        List<Book> books = new ArrayList<>();
        books.add(new Book("Melania", "Melania Trump", 2024, 17.99));

        List<Book> sortedBooks = library.sortByTitle(books);

        assertEquals(1, sortedBooks.size());
        assertEquals("Melania", sortedBooks.get(0).getTitle());
    }
}
