package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnnotationToolTypeTest {

    @Test
    public void testEnumValues() {
        assertEquals(4, AnnotationToolType.values().length);
        assertEquals(AnnotationToolType.PEN, AnnotationToolType.valueOf("PEN"));
        assertEquals(AnnotationToolType.MARKER, AnnotationToolType.valueOf("MARKER"));
        assertEquals(AnnotationToolType.PENCIL, AnnotationToolType.valueOf("PENCIL"));
        assertEquals(AnnotationToolType.POST_IT_NOTE, AnnotationToolType.valueOf("POST_IT_NOTE"));
    }

    @Test
    public void testEnumToString() {
        assertEquals("PEN", AnnotationToolType.PEN.toString());
        assertEquals("MARKER", AnnotationToolType.MARKER.toString());
        assertEquals("PENCIL", AnnotationToolType.PENCIL.toString());
        assertEquals("POST_IT_NOTE", AnnotationToolType.POST_IT_NOTE.toString());
    }
}
