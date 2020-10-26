package com.geraud.ocr_loan_api.temporarybootstrap;

import com.geraud.ocr_loan_api.dao.LoanDao;
import com.geraud.ocr_loan_api.dao.MemberDao;
import com.geraud.ocr_loan_api.domain.Loan;
import com.geraud.ocr_loan_api.domain.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class Bootstrap implements CommandLineRunner {

    private MemberDao memberDao;
    private LoanDao loanDao;

    public Bootstrap(MemberDao memberDao, LoanDao loanDao) {
        this.memberDao = memberDao;
        this.loanDao = loanDao;
    }

    @Override
    public void run(String... args) throws Exception {

        Member member1 = new Member();
        member1.setCardnumber("1234A");
        member1.setEmail("blabla@email.com");

        Loan loan1 = new Loan();
        loan1.setLabel("label1");
        loan1.setTitle("titre 1");
        loan1.setStartingDate(LocalDate.now());
        loan1.setMember(member1);

        Loan loan2 = new Loan();
        loan2.setLabel("label2");
        loan2.setTitle("titre 2");
        loan2.setStartingDate(LocalDate.of(2020,05,02));
        loan2.setMember(member1);

        memberDao.save(member1);
        loanDao.save(loan1);
        loanDao.save(loan2);
    }
}
