package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookshelfTest {

    @Test
    public void testAddBook() {
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();

        // Create a book
        Book book= new Book.BookBuilder()
                .setTitle("Title")
                .setAuthor("Author")
                .setTotalPages(200)
                .build();

        // Add the book to the bookshelf
        bookshelf.addBook(book);

        // Check if the book has been added to the bookshelf
        assertTrue(bookshelf.getBooks().contains(book));
    }

    @Test
    public void testRemoveBook() {
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();

        // Create a book

        Book book= new Book.BookBuilder()
                .setTitle("Title")
                .setAuthor("Author")
                .setTotalPages(200)
                .build();

        // Add the book to the bookshelf
        bookshelf.addBook(book);

        // Remove the book from the bookshelf
        bookshelf.removeBook(book);

        // Check if the book has been removed from the bookshelf
        assertFalse(bookshelf.getBooks().contains(book));
    }

    @Test
    public void testSwitchDisplayMode() {
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();

        // Switch display mode
        bookshelf.setDisplayMode(DisplayMode.LIST);

        DisplayMode actual =bookshelf.getDisplayMode();
        // Check if the display mode is set correctly
        assertEquals(DisplayMode.LIST,actual );
    }

    @Test
    public void testFindBook() {
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();

        // Create books
        Book book1= new Book.BookBuilder()
                .setTitle("Title1")
                .setAuthor("Author1")
                .setTotalPages(200)
                .build();
        Book book2= new Book.BookBuilder()
                .setTitle("Title2")
                .setAuthor("Author2")
                .setTotalPages(200)
                .build();

        // Add books to the bookshelf
        bookshelf.addBook(book1);
        bookshelf.addBook(book2);

        // Find a book by title
        Book foundBook = bookshelf.findBook("Title1");

        // Check if the correct book is found
        assertEquals(book1, foundBook);
    }

    @Test
    public void testRemoveBookByTitle() {
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();

        // Create books
        Book book1= new Book.BookBuilder()
                .setTitle("Title1")
                .setAuthor("Author1")
                .setTotalPages(200)
                .build();
        Book book2= new Book.BookBuilder()
                .setTitle("Title2")
                .setAuthor("Author2")
                .setTotalPages(200)
                .build();

        // Add books to the bookshelf
        bookshelf.addBook(book1);
        bookshelf.addBook(book2);

        // Remove a book by title
        boolean removed = bookshelf.removeBook("Title1");

        // Check if the book is removed successfully
        assertTrue(removed);
        assertFalse(bookshelf.getBooks().contains(book1));
    }

}
