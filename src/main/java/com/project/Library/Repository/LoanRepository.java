package com.project.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Library.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}
