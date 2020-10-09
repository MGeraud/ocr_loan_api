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

    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String address_line1;
    private String address_line2;
    private String zip_code;
    private String city;

    @OneToMany(mappedBy = "user")
    private Set<Loan> loans =new HashSet<>();

}
