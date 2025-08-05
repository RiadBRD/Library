package com.project.Library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Library.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}
