package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
    private String name;
    private List<Book> books;
    private DisplayMode displayMode;

    // Private constructor to enforce the use of builder
    private Bookshelf(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Static method to create a new instance of BookshelfBuilder
    public static BookshelfBuilder builder(String name) {
        return new BookshelfBuilder(name);
    }

    // Method to add a book to the bookshelf
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the bookshelf
    public void removeBook(Book book) {
        books.remove(book);
    }

    public String getName() {
        return this.name;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setDisplayMode(DisplayMode displayMode){

        this.displayMode = displayMode;
    }
    public DisplayMode getDisplayMode() {

        return this.displayMode;
    }
    public void switchDisplayMode(DisplayMode displayMode) {
        setDisplayMode(displayMode);
        System.out.println("Switching to " + displayMode + " display mode...");
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBook(String title) {
        return books.removeIf(book -> book.getTitle().equals(title));
    }

    // Nested static class for builder pattern
    public static class BookshelfBuilder {
        private String name;

        // Constructor with required parameters
        public BookshelfBuilder(String name) {
            this.name = name;
        }

        // Setter for name
        public BookshelfBuilder name(String name) {
            this.name = name;
            return this;
        }

        // Method to build Bookshelf object
        public Bookshelf build() {
            return new Bookshelf(name);
        }
    }
}
