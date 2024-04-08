package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostItNoteTest {

    @Test
    public void testPostItNoteBuilder() {
        AnnotationToolType type = AnnotationToolType.POST_IT_NOTE;
        Color color = Color.RED;
        Double strokeWidth = 0.5;
        String text = "Sample text";
        String message = "This is a post-it note message";

        PostItNote postItNote = new PostItNote.PostItNoteBuilder()
                .setType(type)
                .setColor(color)
                .setWidth(strokeWidth)
                .setText(text)
                .setMessage(message)
                .build();

        assertNotNull(postItNote);
        assertEquals(type, postItNote.getType());
        assertEquals(color, postItNote.getColor());
        assertEquals(strokeWidth, postItNote.getStrokeWidth());
        assertEquals(text, postItNote.getText());
        assertEquals(message, postItNote.getMessage());
    }

    @Test
    public void testGetMessage() {
        String message = "This is a post-it note message";
        PostItNote postItNote = new PostItNote.PostItNoteBuilder()
                .setMessage(message)
                .build();
        assertEquals(message, postItNote.getMessage());
    }
}
