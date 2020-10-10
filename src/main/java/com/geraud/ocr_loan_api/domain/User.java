package com.geraud.ocr_loan_api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String cardnumber;

    @OneToMany(mappedBy = "user")
    private Set<Loan> loans =new HashSet<>();

}
