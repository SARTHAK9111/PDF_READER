package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DisplayModeTest {

    @Test
    public void testVisualDisplayModeToString() {
        assertEquals("VISUAL", DisplayMode.VISUAL.toString());
    }

    @Test
    public void testListDisplayModeToString() {
        assertEquals("LIST", DisplayMode.LIST.toString());
    }



}
