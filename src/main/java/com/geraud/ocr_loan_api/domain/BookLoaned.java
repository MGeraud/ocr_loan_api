package com.geraud.ocr_loan_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class BookLoaned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_book_loaned;

    private String label;
    private String title;

    @OneToMany(mappedBy = "pk.book_loaned")
    @JsonIgnore
    private Set<Loan> loans =new HashSet<>();
}
