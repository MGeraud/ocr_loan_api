package com.geraud.ocr_loan_api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Loan {

    @Id
    private LoanId pk;

    private int refreshEndingCounter;
    private LocalDate startingDate;
    private LocalDate bookBackDate;


}
