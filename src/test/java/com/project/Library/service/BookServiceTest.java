package com.project.Library.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.Library.exceptions.InvalidBookException;
import com.project.Library.model.Book;
import com.project.Library.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void createBook_shouldReturnSavedBook_whenValidInput() {

        // Given
        Book expectedBook = new Book("Naruto", "Masashi Kishimoto", "A boy who wants to be Hokage");
        when(bookRepository.save(any(Book.class))).thenReturn(expectedBook);

        // When
        Book createdBook = bookService.createBook(expectedBook);

        // Then
        assertAll(
                () -> assertEquals("Naruto", createdBook.getTitle()),
                () -> assertEquals("Masashi Kishimoto", createdBook.getAuthor()),
                () -> assertEquals("A boy who wants to be Hokage", createdBook.getSynopsis()));

    }

    @Test
    void createBook_shouldThrowException_whenTitleIsBlank() {
        Book invalidBook = new Book("", "Author", "Synopsis");
        assertThrows(InvalidBookException.class,
                () -> bookService.createBook(invalidBook));
    }

}
