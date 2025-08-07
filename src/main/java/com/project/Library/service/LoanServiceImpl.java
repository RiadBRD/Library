package com.project.Library.service;

import java.time.LocalDateTime;

import com.project.Library.model.Book;
import com.project.Library.model.Loan;
import com.project.Library.model.User;
import com.project.Library.repository.LoanRepository;

public class LoanServiceImpl implements LoanService{

    private LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan createLoan(User user, Book book, LocalDateTime loanDate) {
        return loanRepository.save(new Loan(user,book,loanDate));
    }

}
