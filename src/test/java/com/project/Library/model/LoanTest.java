package com.project.Library.model;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LoanTest {

    @Test
    public void shouldCreateLoanWithAllAttributes(){
         // Given
        Long expectedId = 1L;
        User expectedUser = new User(1L, "Riad", "BENRADI", 27, "0767334891");
        Book expectedBook = new Book(1L,"Naruto","Masashi Kishimoto","A boy who wants to be Hokage");
        LocalDateTime expectedLoanDate = LocalDateTime.now();
        LocalDateTime expectedDueDate = expectedLoanDate.plusDays(14);

        // When
        Loan loan = new Loan(expectedId, expectedUser, expectedBook, expectedLoanDate,expectedDueDate);

        //Then

       //Then
        assertAll(
            () -> assertEquals(expectedId, loan.getId()),
            () -> assertEquals(expectedUser, loan.getBorrower()),
            () -> assertEquals(expectedBook, loan.getLoanedBook()),
            () -> assertEquals(expectedLoanDate.toLocalDate(), loan.getLoanDate().toLocalDate()),
            () -> assertEquals(expectedDueDate.toLocalDate(), loan.getDueDate().toLocalDate())
        );
    }

}
