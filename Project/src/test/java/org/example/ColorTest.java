package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    @Test
    public void testRedColorToString() {
        assertEquals("RED", Color.RED.toString());
    }

    @Test
    public void testBlackColorToString() {
        assertEquals("BLACK", Color.BLACK.toString());
    }

    @Test
    public void testBlueColorToString() {
        assertEquals("BLUE", Color.BLUE.toString());
    }



}
