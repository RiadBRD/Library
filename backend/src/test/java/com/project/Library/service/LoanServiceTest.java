package com.project.Library.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.Library.model.Book;
import com.project.Library.model.Loan;
import com.project.Library.model.User;
import com.project.Library.repository.LoanRepository;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTest{

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanServiceImpl loanService;

    @Test
    void shouldCreateLoanWithCorrectDueDate() {

        // Given
        User expectedUser = new User("Riad", "BENRADI", 27, "0767334891");
        Book expectedBook = new Book("Naruto", "Masashi Kishimoto", "A boy who wants to be Hokage");
        LocalDateTime loanDate = LocalDateTime.now();
        when(loanRepository.save(any())).thenAnswer(inv -> {
            Loan loan = inv.getArgument(0);
            return loan; // Returns the input unchanged
        });

        // When
        Loan createdLoan = loanService.createLoan(new Loan(expectedUser, expectedBook, loanDate));

        // Then
        assertAll(
                () -> assertEquals(loanDate.toLocalDate(), createdLoan.getLoanDate().toLocalDate()),
                () -> assertEquals(14,ChronoUnit.DAYS.between(loanDate, createdLoan.getDueDate())),
                () -> assertEquals("Naruto", createdLoan.getLoanedBook().getTitle()));

    }
}
