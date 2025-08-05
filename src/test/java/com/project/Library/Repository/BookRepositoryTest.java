package com.project.Library.Repository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.Library.model.Book;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class BookRepositoryTest {

    @Autowired 
    private BookRepository bookRepository;

    @Test
    void shouldPersistBookWhenSaved(){
        
        // Given
        Book expectedBook = new Book("Naruto", "Masashi Kishimoto", "A boy who wants to be Hokage");
        Book expectedSavedBook = bookRepository.save(expectedBook);

        assertAll(
                () -> assertNotNull(expectedSavedBook),
                () -> assertEquals("Naruto", expectedSavedBook.getTitle()));
    }

    @Test
    void shouldRetrieveUserByIdWhenExists() {
        Book expectedBook = new Book("Naruto", "Masashi Kishimoto", "A boy who wants to be Hokage");
        Book expectedSavedBook = bookRepository.save(expectedBook);

        Optional<Book> foundBook = bookRepository.findById(expectedSavedBook.getId());

        assertAll(
                () -> assertTrue(foundBook.isPresent()),
                () -> assertEquals("Naruto", foundBook.get().getTitle()));
    }
}
