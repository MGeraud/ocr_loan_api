package com.geraud.ocr_loan_api.controllers;

import com.geraud.ocr_loan_api.domain.Loan;
import com.geraud.ocr_loan_api.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PatchMapping("/loan/{id}")
    public ResponseEntity<Loan> patchLoan(@PathVariable Long id , @RequestBody Loan loan){
        return new ResponseEntity<Loan>(loanService.patchLoan(id, loan) , HttpStatus.OK);
    }

    @PostMapping("/loan/{cardnumber}")
    public ResponseEntity<Loan> createLoan(@PathVariable String cardnumber , @RequestBody Loan loan){
        return new ResponseEntity<Loan>(loanService.createLoan(cardnumber, loan) , HttpStatus.OK);
    }

    @GetMapping("/loan")
    public List<Loan> loansOfMember(@RequestParam("email") String email,
                                    @RequestParam("cardnumber") String cardnumber){
        return loanService.listLoans(email, cardnumber);

    }
}
