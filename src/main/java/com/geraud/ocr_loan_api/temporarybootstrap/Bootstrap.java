package com.geraud.ocr_loan_api.temporarybootstrap;

import com.geraud.ocr_loan_api.dao.LoanDao;
import com.geraud.ocr_loan_api.dao.UserDao;
import com.geraud.ocr_loan_api.domain.Loan;
import com.geraud.ocr_loan_api.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    private UserDao userDao;
    private LoanDao loanDao;

    public Bootstrap(UserDao userDao, LoanDao loanDao) {
        this.userDao = userDao;
        this.loanDao = loanDao;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setCardnumber("1234A");
        user1.setEmail("blabla@email.com");

        Loan loan1 = new Loan();
        loan1.setLabel("label1");
        loan1.setTitle("titre 1");
        loan1.setStartingDate(LocalDate.now());
        loan1.setUser(user1);

        Loan loan2 = new Loan();
        loan2.setLabel("label2");
        loan2.setTitle("titre 2");
        loan2.setStartingDate(LocalDate.of(2020,05,02));
        loan2.setUser(user1);

        userDao.save(user1);
        loanDao.save(loan1);
        loanDao.save(loan2);
    }
}
