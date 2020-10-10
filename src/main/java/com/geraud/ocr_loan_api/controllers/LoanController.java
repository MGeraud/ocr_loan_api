package com.geraud.ocr_loan_api.controllers;

import com.geraud.ocr_loan_api.domain.Loan;
import com.geraud.ocr_loan_api.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PatchMapping("/loan/{id}")
    public ResponseEntity<Loan> patchLoan(@PathVariable Long id , @RequestBody Loan loan){
        return new ResponseEntity<Loan>(loanService.patchLoan(id, loan) , HttpStatus.OK);
    }

}
