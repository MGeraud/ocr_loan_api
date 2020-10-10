package com.geraud.ocr_loan_api.services;

import com.geraud.ocr_loan_api.domain.Loan;

public interface LoanService {

    Loan patchLoan(Long id , Loan loan);
}
