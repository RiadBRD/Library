package com.project.Library.model;

import java.time.LocalDateTime;

public class Loan {
    private Long id;
    private User borrower;
    private Book loanedBook;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private final static int TimeOfLoan = 14;
    
    public Loan(Long id, User borrower, Book loanedBook, LocalDateTime loanDate, LocalDateTime dueDate) {
        this.id = id;
        this.borrower = borrower;
        this.loanedBook = loanedBook;
        this.loanDate = LocalDateTime.now();
        this.dueDate = loanDate.plusDays(TimeOfLoan);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Book getLoanedBook() {
        return loanedBook;
    }

    public void setLoanedBook(Book loanedBook) {
        this.loanedBook = loanedBook;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public static int getTimeofloan() {
        return TimeOfLoan;
    }

    

    
}
