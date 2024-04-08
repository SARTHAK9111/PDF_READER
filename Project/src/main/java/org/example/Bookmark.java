package org.example;

public class Bookmark {
    private String title;
    private String label;
    private int pageNumber;

    private Bookmark(BookmarkBuilder builder) {
        this.pageNumber = builder.pageNumber;
        this.label = builder.label;
        this.title = builder.title;
    }

    // Getters and setters for title, label, and pageNumber

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    // BookmarkBuilder class
    public static class BookmarkBuilder {
        private String title;
        private String label;
        private int pageNumber;

        public BookmarkBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookmarkBuilder setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            this.label = "p" + pageNumber; // Automatically set label based on pageNumber
            return this;
        }

        public Bookmark build() {
            return new Bookmark(this);
        }
    }
}
