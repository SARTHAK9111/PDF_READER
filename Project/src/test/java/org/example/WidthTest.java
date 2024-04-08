package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WidthTest {

    @Test
    public void testEnumValues() {
        assertEquals("SMALL", Width.SMALL.toString());
        assertEquals("LARGE", Width.LARGE.toString());
        assertEquals("MEDIUM", Width.MEDIUM.toString());
    }

    @Test
    public void testEnumOrder() {
        Width[] values = Width.values();
        assertEquals(3, values.length);
        assertEquals(Width.SMALL, values[0]);
        assertEquals(Width.LARGE, values[1]);
        assertEquals(Width.MEDIUM, values[2]);
    }
}
