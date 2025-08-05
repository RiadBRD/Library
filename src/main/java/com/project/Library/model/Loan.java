package com.project.Library.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrower;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book loanedBook;

    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private final static int TimeOfLoan = 14;

    public Loan() {

    }

    public Loan(User borrower, Book loanedBook, LocalDateTime loanDate) {
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
