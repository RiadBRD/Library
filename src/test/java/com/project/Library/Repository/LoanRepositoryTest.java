package com.project.Library.Repository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.Library.model.Book;
import com.project.Library.model.Loan;
import com.project.Library.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;

    @Test
    void shouldPersistLoanWhenSaved() {
        // Given
        User expectedUser = new User("Riad", "BENRADI", 27, "0767334891");
        Book expectedBook = new Book("Naruto", "Masashi Kishimoto", "A boy who wants to be Hokage");
        Loan expectedLoan = new Loan(expectedUser,expectedBook,LocalDateTime.now());

        //When
        Loan expectedSavedLoan = loanRepository.save(expectedLoan);

       //Then
        assertAll(
                () -> assertNotNull(expectedSavedLoan),
                () -> assertEquals("Riad", expectedSavedLoan.getBorrower().getFirstname()));
    }

}
