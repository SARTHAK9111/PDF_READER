package org.example;

import java.util.*;

class Book {
    private String title;
    private String author;
    private List<String> tags;
    private int totalPages;
    private int currentPage;
    private Map<Integer, Page> pageMap;
    private List<Bookmark> bookmarks;

    private Book(String title, String author, int totalPages) {
        this.title = title;
        this.author = author;
        this.tags = new ArrayList<>();
        this.totalPages = totalPages;
        this.currentPage = 1;
        this.pageMap = new HashMap<>();
        initializePages();
        bookmarks = new ArrayList<>();
    }

    public static class BookBuilder {
        private String title;
        private String author;
        private int totalPages;

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Book build() {
            return new Book(title, author, totalPages);
        }
    }
    private void initializePages() {
        for (int i = 1; i <= totalPages; i++) {
            Page page = Page.builder(i).build();
            pageMap.put(i, page);
        }
    }


    public List<Bookmark> getBookmarks(){
        return bookmarks;
    }

    // Getters and setters for book attributes
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String  getContent(Page curPage) {

        return curPage.getContent();
    }
    public List<AnnotationTool> getAnnotations(int currentPage){
        Page currentPageObj = pageMap.get(currentPage);
        return currentPageObj.getAnnotations();

    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public int getCurrentPage(){
        return currentPage;
    }

    public void nextPage() {
        if (currentPage == totalPages) {
            System.out.println("You are on the last page.");
        } else {
            currentPage++;
            System.out.println("You are on Page Number " + currentPage);
        }
    }

    public void prevPage() {
        if (currentPage == 1) {
            System.out.println("You are on the first page.");
        } else {
            currentPage--;
            System.out.println("You are on Page Number " + currentPage);
        }
    }

    public int getPageNumber(String label) {
        for (Bookmark bookmark : bookmarks) {
            if (bookmark.getTitle().equals(label)) {
                return bookmark.getPageNumber();
            }
        }
        return -1; // Return -1 if the bookmark with the given label is not found
    }
    public void addAnnotation(Scanner scanner) {
        Page currentPageObj = pageMap.get(currentPage);
        if (currentPageObj != null) {
            currentPageObj.addAnnotation(addAnnotationToPage(currentPage, scanner));
        } else {
            System.out.println("Error: Current page not found.");
        }
    }

    public AnnotationTool addAnnotationToPage(int curPage, Scanner scanner) {
        System.out.println("Please enter the text you want to add Annotation on page number:");
        String text = scanner.nextLine();

        System.out.println("Please select the type of Annotation :");
        System.out.println("1. Pen");
        System.out.println("2. Marker");
        System.out.println("3. Eraser");
        System.out.println("4. Post-it Note");

        AnnotationToolType type = null;
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                type = AnnotationToolType.PEN;
                break;
            case 2:
                type = AnnotationToolType.MARKER;
                break;
            case 3:
                type = AnnotationToolType.PENCIL; // Assuming PENCIL is correct, change if necessary
                break;
            case 4:
                return addPostItNoteAnnotation(text, scanner);
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 4.");
        }

        System.out.println("Please enter the color of the Annotation:");
        System.out.println("1. Red");
        System.out.println("2. Black");
        System.out.println("3. Blue");

        Color color = null;
        int annotationColor = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (annotationColor) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.BLACK;
                break;
            case 3:
                color = Color.BLUE;
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 3.");
        }

        System.out.println("Please enter the width of the Annotation:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        int annotationWidth = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Double width = 0.5; // Default width

        switch (annotationWidth) {
            case 1:
                width = 0.5;
                break;
            case 2:
                width = 0.75;
                break;
            case 3:
                width = 1.00;
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 3.");
        }

        // Create an AnnotationToolBuilder and set its attributes
        AnnotationTool.AnnotationToolBuilder builder = new AnnotationTool.AnnotationToolBuilder()
                .setType(type)
                .setColor(color)
                .setStrokeWidth(width)
                .setText(text);

        // Build the AnnotationTool object
        return builder.build();
    }


    private PostItNote addPostItNoteAnnotation(String text, Scanner scanner) {
        System.out.println("Please enter the color of the Post-it Note:");
        System.out.println("1. Red");
        System.out.println("2. Black");
        System.out.println("3. Blue");

        Color color = null;
        int annotationColor = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (annotationColor) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.BLACK;
                break;
            case 3:
                color = Color.BLUE;
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 3.");
        }

        System.out.println("Please enter the width of the Post-it Note:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        int annotationWidth = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Double width = 0.5; // Default width

        switch (annotationWidth) {
            case 1:
                width = 0.5;
                break;
            case 2:
                width = 0.75;
                break;
            case 3:
                width = 1.00;
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 3.");
        }

        System.out.println("Please enter the message for the Post-it Note:");
        String message = scanner.nextLine();

        // Use the builder to construct the PostItNote object
        return new PostItNote.PostItNoteBuilder()
                .setColor(color)
                .setWidth(width)
                .setText(text)
                .setMessage(message)
                .build();
    }

    public int jumptoPage(Scanner scanner) {
        System.out.println("Please enter the PageNumber you want to Jump");

        int newPage = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (pageMap.containsKey(newPage)) {
            currentPage = newPage;
            System.out.println("You have jumped to page number " + currentPage);
        } else {
            System.out.println("Error: Page " + newPage + " does not exist.");
        }

        return currentPage;
    }
    public void removeAnnotation(Scanner scanner) {
        Page currentPageObj = pageMap.get(currentPage);
        if (currentPageObj != null) {
            removeAnnotationFromPage(currentPageObj ,scanner);
        } else {
            System.out.println("Error: Current page not found.");
        }
    }

    public void removeAnnotationFromPage(Page currentPageObj,Scanner scanner) {
        int page= currentPageObj.getPageNumber();
        System.out.println( "you are on the page "+ page);
        System.out.println("Please enter the annotation text you want to remove:");
        String annotationText = scanner.nextLine();

        List<AnnotationTool> annotations = currentPageObj.getAnnotations();

        if (annotations == null || annotations.isEmpty()) {
            System.out.println("No annotations found for the current page.");
            return;
        }

        boolean annotationRemoved = false;

        Iterator<AnnotationTool> iterator = annotations.iterator();
        while (iterator.hasNext()) {
            AnnotationTool annotation = iterator.next();
            if (annotation.getText().equals(annotationText)) {
                iterator.remove();
                annotationRemoved = true;
                System.out.println("Annotation removed successfully.");
                break;
            }
        }

        if (!annotationRemoved) {
            System.out.println("Annotation not found.");
        }
    }





    public void addBookmark(int page, Scanner scanner) {
        System.out.println("Please enter the Title for the Bookmark");
        String title = scanner.nextLine();

        Bookmark bookmark = new Bookmark.BookmarkBuilder()
                .setTitle(title)
                .setPageNumber(page)
                .build();

        bookmarks.add(bookmark);
        System.out.println("Bookmark added successfully: " + bookmark.getLabel() + " " + bookmark.getTitle());
    }

    public void goToBookmark(Scanner scanner) {
        System.out.println("Please enter the title of the bookmark you want to navigate to:");
        String label = scanner.nextLine();

        int pageNumber =getPageNumber(label); // Assuming a method to retrieve the page number for a given label

        if (pageNumber != -1) {
            currentPage = pageNumber;
            System.out.println("Navigated to bookmarked page: " + currentPage);
        } else {
            System.out.println("Bookmark not found.");
        }
    }
    public void editBookmark(Scanner scanner) {
        System.out.println("Please enter the bookmark title you want to change:");
        String oldLabel = scanner.nextLine();
        System.out.println("Please enter the new title for the bookmark:");
        String newLabel = scanner.nextLine();

        for (Bookmark bookmark : bookmarks) {
            if (bookmark.getTitle().equals(oldLabel)) {
                bookmark.setTitle(newLabel);
                System.out.println("Bookmark label updated successfully: " + newLabel);
                return;
            }
        }

        System.out.println("Bookmark with Title '" + oldLabel + "' not found.");
    }

    public void slideToPage(Scanner scanner) {
        System.out.println("please enter the plage Number you want to slide to :");
        int pageNumber= scanner.nextInt();
        if (pageNumber >= 1 && pageNumber <= totalPages) {
            currentPage = pageNumber;
            System.out.println("Jumped to Page Number: " + currentPage);
        } else {
            System.out.println("Invalid page number!");
        }
    }


}