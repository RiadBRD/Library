package com.project.Library.service;

import java.time.LocalDateTime;

import com.project.Library.model.Book;
import com.project.Library.model.Loan;
import com.project.Library.model.User;

public interface LoanService {
    Loan createLoan(User user,Book book,LocalDateTime loanDate);
}
