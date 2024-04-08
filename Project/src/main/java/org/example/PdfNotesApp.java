package org.example;

import java.util.List;
import java.util.Scanner;

public class PdfNotesApp {
    public static void main(String[] args) {
        boolean exit = false; // Declare and initialize exit variable
        // Create a bookshelf
        Bookshelf bookshelf = Bookshelf.builder("My Bookshelf").build();

        // Create some sample books
        Book book1 = new Book.BookBuilder()
                .setTitle("Sample Book")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();

        Book book2= new Book.BookBuilder()
                .setTitle("Sample Book2")
                .setAuthor("Sarthak 2")
                .setTotalPages(2111)
                .build();;

        // Add books to the bookshelf
        bookshelf.addBook(book1);
        bookshelf.addBook(book2);

        // Display the number of books on the bookshelf along with the bookshelf name
        System.out.println("Bookshelf Name: " + bookshelf.getName());
        System.out.println("Number of Books: " + bookshelf.getBooks().size());

        System.out.println("Please enter the Mode of the Visual");
        System.out.println("1- Display Mode ");
        System.out.println("2- List Display Mode");

        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        DisplayMode displayMode;

        switch (inputInt) {
            case 1:
                displayMode = DisplayMode.VISUAL;
                break;
            case 2:
                displayMode = DisplayMode.LIST;
                break;
            default:
                System.out.println("Invalid input. Defaulting to List Display Mode.");
                displayMode = DisplayMode.LIST;
        }

        bookshelf.switchDisplayMode(displayMode);

        while (!exit) {
            System.out.println("Please select an action:");
            System.out.println("1. Edit a book");
            System.out.println("2. Delete a book");
            System.out.println("3. Read a book");
            System.err.println("4. Select Books");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    editBook(bookshelf, scanner);
                    break;
                case 2:
                    deleteBook(bookshelf, scanner);
                    break;
                case 3:
                    readBook(bookshelf, scanner);
                    break;
                case 4:
                    selectBook(bookshelf, scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }

        scanner.close();
    }

    protected static void editBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("Enter the title of the book you want to edit:");
        String title = scanner.nextLine();
        Book book = bookshelf.findBook(title);
        if (book != null) {
            System.out.println("Enter the new title for the book:");
            String newTitle = scanner.nextLine();
            book.setTitle(newTitle);
            System.out.println("Book title updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    static void deleteBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("Enter the title of the book you want to delete:");
        String title = scanner.nextLine();
        boolean deleted = bookshelf.removeBook(title);
        if (deleted) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    static void readBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("Enter the title of the book you want to read:");
        String title = scanner.nextLine();
        Book book = bookshelf.findBook(title);
        if (book != null) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            int pageNumber = 1;

            boolean exit = false;
            while (!exit) {
                System.out.println("Please select an action:");
                System.out.println("1. Next Page");
                System.out.println("2. Previous page");
                System.out.println("3. Jump to page number");
                System.out.println("4. Add Annotation");
                System.out.println("5. Remove Annotation");
                System.out.println("6. Add Bookmark");
                System.out.println("7. Edit Bookmark");
                System.out.println("8. Go to Bookmark");
                System.out.println("9. Swtich Book");
                System.out.println("10. Page Slider");
                System.out.println("11. Exist");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        book.nextPage();
                        break;
                    case 2:
                        book.prevPage();
                        break;
                    case 3:
                        pageNumber = book.jumptoPage(scanner);
                        break;
                    case 4:
                        book.addAnnotation(scanner);
                        break;
                    case 5:
                        book.removeAnnotation(scanner);
                        break;
                    case 6:
                        book.addBookmark(pageNumber,scanner);
                        break;
                    case 7:
                        book.editBookmark( scanner);
                        break;
                    case 8:

                        book.goToBookmark( scanner);
                        break;
                    case 9:
                        selectBook(bookshelf, scanner);
                        break;
                    case 10:
                        book.slideToPage(scanner);
                    case 11:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 9.");
                }
            }
        } else {
            System.out.println("Book not found.");
        }



    }



    private static void readafterselecting(Bookshelf bookshelf, String title, Scanner scanner){
        Book book = bookshelf.findBook(title);
        if (book != null) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            int pageNumber = 1;


            boolean exit = false;
            while (!exit) {
                System.out.println("Please select an action:");
                System.out.println("1. Next Page");
                System.out.println("2. Previous page");
                System.out.println("3. Jump to page number");
                System.out.println("4. Add Annotation");
                System.out.println("5. Remove Annotation");
                System.out.println("6. Add Bookmark");
                System.out.println("7. Edit Bookmark");
                System.out.println("8. Go to Bookmark");
                System.err.println("9. Switch Book");
                System.out.println("10. Page Slider");
                System.out.println("11. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        book.nextPage();
                        break;
                    case 2:
                        book.prevPage();
                        break;
                    case 3:
                        pageNumber = book.jumptoPage(scanner);
                        break;
                    case 4:
                        book.addAnnotation(scanner);
                        break;
                    case 5:
                        book.removeAnnotation(scanner);
                        break;
                    case 6:
                        book.addBookmark(pageNumber,scanner);
                        break;
                    case 7:
                        book.editBookmark( scanner);
                        break;
                    case 8:

                        book.goToBookmark( scanner);
                    case 9:
                        selectBook(bookshelf, scanner);
                        break;
                    case 10:
                        book.slideToPage(scanner);
                        break;
                    case 11:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 9.");
                }
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    static void selectBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("Select a book from the list:");
        int index = 1;
        List<Book> Books =  bookshelf.getBooks();
        for (Book book : Books) {
            System.out.println(index + ". " + book.getTitle());
            index++;
        }
        System.out.println(index + ".  Go Back");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if(choice!= index){
            if (choice >= 1 && choice <= Books.size()) {
                Book selectedBook = Books.get(choice - 1);
                System.out.println("Selected book: " + selectedBook.getTitle());
                readafterselecting(bookshelf, selectedBook.getTitle(), scanner);
            } else {
                System.out.println("Invalid choice. Please select a book from the list.");
            }
        }
    }

}
