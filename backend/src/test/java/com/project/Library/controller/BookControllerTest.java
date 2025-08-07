package com.project.Library.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Library.model.Book;
import com.project.Library.service.BookService;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc(addFilters = false)
public class BookControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private BookService bookService;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        public void createBook_ShouldReturnCreatedBook() throws Exception {

                // Given
                Book inputBook = new Book("To Kill a Mockingbird", "Harper Lee",
                                "A story about racial injustice in the Deep South.");
                Book savedBook = new Book("To Kill a Mockingbird", "Harper Lee",
                                "A story about racial injustice in the Deep South.");
                savedBook.setId(1L);

                when(bookService.createBook(any(Book.class))).thenReturn(savedBook);

                // When & Then
                mockMvc.perform(
                                post("/api/books")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(objectMapper.writeValueAsString(inputBook)))
                                .andExpect(status().isCreated())
                                .andExpect(jsonPath("$.id").value(1L))
                                .andExpect(jsonPath("$.title").value("To Kill a Mockingbird")); // Check 1 book field

        }

        @Test
        public void getBooksByAuthor_ShouldReturn200WithBooks() throws Exception {
                // Given
                String author = "J.K. Rowling";
                Book book = new Book("HP 1", author, "...");
                when(bookService.getBooksByAuthor(author)).thenReturn(Arrays.asList(book));

                // When & Then
                mockMvc.perform(get("/api/books")
                                .param("author", author))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[0].title").value("HP 1"))
                                .andExpect(jsonPath("$[0].author").value(author));
        }

}
