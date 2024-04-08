package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;
import static org.example.PdfNotesApp.editBook;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PdfNotesAppTest {

    @Test
    void testEditBook() {
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();
        Book book1 = new Book.BookBuilder()
                .setTitle("Java Programming")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();
        bookshelf.addBook(book1);

        // Prepare input
        String input = "Java Programming\nNew Title\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Execute method to test
        editBook(bookshelf, new Scanner(System.in));

        // Check if book title is updated
        assertEquals("New Title", bookshelf.findBook("New Title").getTitle());
    }
    @Test
    void testDeleteBook() {
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();
        Book book1 = new Book.BookBuilder()
                .setTitle("Java Programming")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();
        bookshelf.addBook(book1);

        // Prepare input
        String input = "Java Programming\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Execute method to test
        PdfNotesApp.deleteBook(bookshelf, new Scanner(System.in));

        // Check if book is deleted
        assertNull(bookshelf.findBook("Java Programming"));
    }




        @Test
        void testReadBook_Page_turn() {
            // Create a bookshelf
            Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();
            Book book1 = new Book.BookBuilder()
                    .setTitle("Java Programming")
                    .setAuthor("John Doe")
                    .setTotalPages(200)
                    .build();
            bookshelf.addBook(book1);

            // Prepare input
            String input = "Java Programming\n3\n6\n11\n5";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            PdfNotesApp.readBook(bookshelf, new Scanner(System.in));

            assertEquals(6, book1.getCurrentPage(), "Page number should be incremented after choosing 'Next Page' option");
            book1.nextPage();
            assertEquals(7, book1.getCurrentPage(), "Page number should be incremented after choosing 'Next Page' option");
            book1.prevPage();
            assertEquals(6, book1.getCurrentPage(), "Page number should be incremented after choosing 'Next Page' option");

        }

    @Test
    void testSelectBook() {
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();
        Book book1 = new Book.BookBuilder()
                .setTitle("Java Programming")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();
        Book book2 = new Book.BookBuilder()
                .setTitle("Data Structure")
                .setAuthor(" Doe")
                .setTotalPages(200)
                .build();
        bookshelf.addBook(book1);
        bookshelf.addBook(book2);

        // Prepare input
        String input = "1\n11\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Execute method to test
        PdfNotesApp.selectBook(bookshelf, new Scanner(System.in));
        assertEquals("Java Programming",book1.getTitle());
        assertNotEquals("Data Structures and Algorithms", book1.getTitle());

    }



}