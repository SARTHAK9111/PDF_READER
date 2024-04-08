package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnnotationToolTest {

    @Test
    public void testAnnotationBuilder() {
        AnnotationTool.AnnotationToolBuilder builder = new AnnotationTool.AnnotationToolBuilder();
        builder.setType(AnnotationToolType.PEN)
                .setColor(Color.RED)
                .setStrokeWidth(1.0)
                .setText("Sample text");

        AnnotationTool annotationTool = builder.build();

        assertNotNull(annotationTool);
        assertEquals(AnnotationToolType.PEN, annotationTool.getType());
        assertEquals(Color.RED, annotationTool.getColor());
        assertEquals(1.0, annotationTool.getStrokeWidth());
        assertEquals("Sample text", annotationTool.getText());
    }

    @Test
    public void testAnnotationConstructor() {
        AnnotationTool annotationTool = new AnnotationTool(AnnotationToolType.MARKER, Color.BLUE, 0.5, "Another text");

        assertNotNull(annotationTool);
        assertEquals(AnnotationToolType.MARKER, annotationTool.getType());
        assertEquals(Color.BLUE, annotationTool.getColor());
        assertEquals(0.5, annotationTool.getStrokeWidth());
        assertEquals("Another text", annotationTool.getText());
    }
}
