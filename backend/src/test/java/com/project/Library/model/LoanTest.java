package com.project.Library.model;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.project.Library.model.Book;
import com.project.Library.model.Loan;
import com.project.Library.model.User;

public class LoanTest {

    @Test
    public void shouldCreateLoanWithAllAttributes() {
        // Given

        User expectedUser = new User("Riad", "BENRADI", 27, "0767334891");
        Book expectedBook = new Book("Naruto", "Masashi Kishimoto", "A boy who wants to be Hokage");
        LocalDateTime expectedLoanDate = LocalDateTime.now();

        // When
        Loan loan = new Loan(expectedUser, expectedBook, expectedLoanDate);

        // Then

        // Then
        assertAll(
                () -> assertEquals(expectedUser, loan.getBorrower()),
                () -> assertEquals(expectedBook, loan.getLoanedBook()),
                () -> assertEquals(expectedLoanDate.toLocalDate(), loan.getLoanDate().toLocalDate()),
                () -> assertEquals(LocalDateTime.now().plusDays(14).toLocalDate(), loan.getDueDate().toLocalDate()));
    }

}
