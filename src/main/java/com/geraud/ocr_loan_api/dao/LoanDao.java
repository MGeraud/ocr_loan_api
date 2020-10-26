package com.geraud.ocr_loan_api.dao;

import com.geraud.ocr_loan_api.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanDao extends JpaRepository<Loan , Long> {
    List<Loan> findAllByBookBackDateIsNullAndStartingDateLessThanAndRefreshEndingCounterEquals(LocalDate date , int refresh);

    @Query("SELECT loans FROM Loan loans WHERE loans.member.id = :memberID")
    List<Loan> findByMemberID(Long memberID);
}
