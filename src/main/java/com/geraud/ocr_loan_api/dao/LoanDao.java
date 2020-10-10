package com.geraud.ocr_loan_api.dao;

import com.geraud.ocr_loan_api.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDao extends JpaRepository<Loan , Long> {
}
