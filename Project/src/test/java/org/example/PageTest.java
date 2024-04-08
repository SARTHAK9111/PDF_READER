package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PageTest {

    @Test
    public void testPageBuilder() {
        int pageNumber = 1;
        Page page = Page.builder(pageNumber).build();
        assertNotNull(page);
        assertEquals(pageNumber, page.getPageNumber());
        assertTrue(page.getAnnotations().isEmpty());
    }

    @Test
    public void testAddAnnotation() {
        Page page = Page.builder(1).build();
        AnnotationTool annotation = new AnnotationTool(AnnotationToolType.PEN, Color.RED, 0.5, "Sample text");
        page.addAnnotation(annotation);
        assertFalse(page.getAnnotations().isEmpty());
        assertEquals(annotation, page.getAnnotations().get(0));
    }

    @Test
    public void testRemoveAnnotation() {
        Page page = Page.builder(1).build();
        AnnotationTool annotation = new AnnotationTool(AnnotationToolType.PEN, Color.RED, 0.5, "Sample text");
        page.addAnnotation(annotation);
        assertFalse(page.getAnnotations().isEmpty());
        page.removeAnnotation(annotation);
        assertTrue(page.getAnnotations().isEmpty());
    }

    @Test
    public void testContent() {
        int pageNumber = 1;
        Page page = Page.builder(pageNumber).build();
        assertEquals("This is the content of page " + pageNumber, page.getContent());
    }
}
