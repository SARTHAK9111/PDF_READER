package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
class BookTest   {

    @Test
    void testAddAnnotationToPage() {
        // Prepare input for scanner
        String input = "Annotation Text\n1\n1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Create a scanner
        Scanner scanner = new Scanner(System.in);

        // Execute the addAnnotationToPage method
        Book book2 = new Book.BookBuilder()
                .setTitle("Sample Book")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();
        AnnotationTool annotation =book2.addAnnotationToPage(book2.getCurrentPage(),scanner);

        // Reset System.in
        System.setIn(System.in);

        // Check if the annotation was created successfully with the specified parameters
        assertEquals("Annotation Text", annotation.getText());
        assertEquals(AnnotationToolType.PEN, annotation.getType());
        assertEquals(Color.RED, annotation.getColor());

    }

    @Test
    void testRemoveAnnotationFromPage() {
        // Create a mock page object
        Page page = Page.builder(1).build(); // Assuming Page class exists with constructor taking page number

        // Create some sample annotations
        AnnotationTool annotation1 = new AnnotationTool(AnnotationToolType.MARKER,Color.RED,0.75,"Annotation 1");
        AnnotationTool annotation2 = new AnnotationTool(AnnotationToolType.PEN,Color.BLACK,0.5,"Annotation 2");
        AnnotationTool annotation3 = new AnnotationTool(AnnotationToolType.POST_IT_NOTE, Color.BLUE,0.1,"Annotation 3");

        // Add annotations to the page
        List<AnnotationTool> annotations = new ArrayList<>();
        annotations.add(annotation1);
        annotations.add(annotation2);
        annotations.add(annotation3);

        InputStream originalSystemIn = System.in;
        Book book2 = new Book.BookBuilder()
                .setTitle("Sample Book")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();;

        book2.getAnnotations(1).add(annotation1);
        book2.getAnnotations(1).add(annotation2);
        book2.getAnnotations(1).add(annotation3);

        String input = "Annotation 2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        book2.removeAnnotation(scanner);

        // Set up input stream for scanner

        System.setIn(System.in);



        // Assertions
        assertEquals(2, book2.getAnnotations(1).size()); // Check if one annotation was removed
         // Check if annotation 2 was removed
    }

    @Test
    public void testAddBookmark() {
        // Setup




        Page page = Page.builder(1).build();
        Book book2 = new Book.BookBuilder()
                .setTitle("Sample Book")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();



        String input = "BookMark\n11\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        book2.addBookmark(1,scanner);
        System.setIn(System.in);

        assertEquals("BookMark",book2.getBookmarks().get(0).getTitle());
    }

    @Test
    public void testEditbook(){
        Page page = Page.builder(1).build();
        Book book2 = new Book.BookBuilder()
                .setTitle("Sample Book")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();
        Bookmark bookmark = new Bookmark.BookmarkBuilder()
                .setTitle("BookMark")
                .setPageNumber(1)
                .build();
        book2.getBookmarks().add(bookmark);


        String input = "BookMark\nNewBookMark\n11\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        book2.editBookmark(scanner);
        System.setIn(System.in);

        assertEquals("NewBookMark",book2.getBookmarks().get(0).getTitle());
    }

    @Test
    public void testgotoBookmark(){
        Page page = Page.builder(1).build();
        Book book2 = new Book.BookBuilder()
                .setTitle("Sample Book")
                .setAuthor("John Doe")
                .setTotalPages(200)
                .build();

        Bookmark bookmark1 = new Bookmark.BookmarkBuilder()
                .setTitle("bookmark1")
                .setPageNumber(1)
                .build();

        Bookmark bookmark2 = new Bookmark.BookmarkBuilder()
                .setTitle("bookmark2")
                .setPageNumber(6)
                .build();



        book2.getBookmarks().add(bookmark1);
        book2.getBookmarks().add(bookmark2);


        String input = "bookmark2\n11\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        book2.goToBookmark(scanner);
        System.setIn(System.in);

        assertEquals(6,book2.getCurrentPage());

    }
}