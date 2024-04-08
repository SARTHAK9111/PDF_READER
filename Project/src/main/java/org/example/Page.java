package org.example;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private int pageNumber;
    private List<AnnotationTool> annotations;

    // Private constructor to enforce the use of builder
    private Page(int pageNumber) {
        this.pageNumber = pageNumber;
        this.annotations = new ArrayList<>();
    }

    // Static method to create a new instance of PageBuilder
    public static PageBuilder builder(int pageNumber) {
        return new PageBuilder(pageNumber);
    }

    // Getters for page attributes
    public int getPageNumber() {
        return pageNumber;
    }

    public List<AnnotationTool> getAnnotations() {
        return annotations;
    }

    public String getContent() {
        return "This is the content of page " + pageNumber;
    }

    // Method to add annotation to the page
    public void addAnnotation(AnnotationTool annotation) {
        annotations.add(annotation);
    }

    // Method to remove annotation from the page
    public void removeAnnotation(AnnotationTool annotation) {
        annotations.remove(annotation);
    }

    // Nested static class for builder pattern
    public static class PageBuilder {
        private int pageNumber;

        // Constructor with required parameter
        public PageBuilder(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        // Method to build Page object
        public Page build() {
            return new Page(pageNumber);
        }
    }
}
