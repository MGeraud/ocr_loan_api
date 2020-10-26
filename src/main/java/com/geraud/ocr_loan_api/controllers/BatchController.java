package com.geraud.ocr_loan_api.controllers;

import com.geraud.ocr_loan_api.domain.Loan;
import com.geraud.ocr_loan_api.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BatchController {
    @Autowired
    BatchService batchService;

    @GetMapping("/batch")
    public List<Loan> batchDtoList(@RequestParam("date") String date,
                                   @RequestParam("refresh") int refresh){
        return batchService.findTitleAndEmail(LocalDate.parse(date), refresh);
    }
}
