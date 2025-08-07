package com.project.Library.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Library.model.Book;
import com.project.Library.model.Loan;
import com.project.Library.model.User;
import com.project.Library.service.LoanService;

@WebMvcTest(LoanController.class)
@AutoConfigureMockMvc(addFilters = false)
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanService loanService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createLoan_ShouldReturnCreatedUser() throws Exception {
        // Given
        User user = new User("Chirine", "EL BADRAOUI", 23, "0625190637");
        Book book = new Book("Naruto", "Masashi Kishimoto", "A boy who wants to be Hokage");

        Loan inputLoan = new Loan(user, book, LocalDateTime.now());
        Loan savedLoan = new Loan(user, book, LocalDateTime.now());
        savedLoan.setId(1L);

        when(loanService.createLoan(any(Loan.class))).thenReturn(savedLoan);

        // When & Then
        mockMvc.perform(
                post("/api/loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputLoan)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.borrower.firstname").value("Chirine")) // Check 1 user field
                .andExpect(jsonPath("$.loanedBook.title").value("Naruto")); // Check 1 book field

    }

}
