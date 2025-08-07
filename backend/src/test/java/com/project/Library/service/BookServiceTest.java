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

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    public void getBooksByAuthor_ShouldReturnFilteredBooks() {
        String author = "J.K. Rowling";
        Book book1 = new Book("HP 1", author, "...");
        Book book2 = new Book("HP 2", author, "...");

        List<Book> expectedBooks = Arrays.asList(book1,book2);

        when(bookRepository.findByAuthor(author)).thenReturn(expectedBooks);

        List<Book> result = bookService.getBooksByAuthor(author);

        assertThat(result).hasSize(2).allMatch(b->b.getAuthor().equals(author));
    }

}
