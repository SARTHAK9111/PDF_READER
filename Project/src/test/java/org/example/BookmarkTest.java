package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkTest {

    @Test
    public void testBookmarkBuilder() {
        Bookmark.BookmarkBuilder builder = new Bookmark.BookmarkBuilder();
        builder.setTitle("Sample Title");
        builder.setPageNumber(5);
        Bookmark bookmark = builder.build();

        assertEquals("Sample Title", bookmark.getTitle());
        assertEquals("p5", bookmark.getLabel());
        assertEquals(5, bookmark.getPageNumber());
    }

    @Test
    public void testGettersAndSetters() {
        Bookmark bookmark = new Bookmark.BookmarkBuilder()
                .setTitle("Another Title")
                .setPageNumber(10)
                .build();

        assertEquals("Another Title", bookmark.getTitle());
        assertEquals("p10", bookmark.getLabel());
        assertEquals(10, bookmark.getPageNumber());

        bookmark.setTitle("Updated Title");
        bookmark.setLabel("p20");
        bookmark.setPageNumber(20);

        assertEquals("Updated Title", bookmark.getTitle());
        assertEquals("p20", bookmark.getLabel());
        assertEquals(20, bookmark.getPageNumber());
    }
}
