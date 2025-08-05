package com.project.Library.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void shouldCreateBookWithAllAttributes() {
        // Given
        String expectedTitle = "Naruto";
        String expectedAuthor = "Masashi Kishimoto";
        String expectedSynopsis = "A boy who wants to be Hokage";

        // When
        Book book = new Book(expectedTitle, expectedAuthor, expectedSynopsis);

        // Then
        assertAll(
                () -> assertEquals(expectedTitle, book.getTitle()),
                () -> assertEquals(expectedAuthor, book.getAuthor()),
                () -> assertEquals(expectedSynopsis, book.getSynopsis()));
    }

}
