package com.geraud.ocr_loan_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class LoanId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_book_loaned")
    private BookLoaned book_loaned;
}
