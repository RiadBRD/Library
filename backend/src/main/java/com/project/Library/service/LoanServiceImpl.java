package com.project.Library.service;

import org.springframework.stereotype.Service;

import com.project.Library.model.Loan;
import com.project.Library.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService{

    private LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

}
