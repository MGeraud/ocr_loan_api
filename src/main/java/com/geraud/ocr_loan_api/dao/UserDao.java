package com.geraud.ocr_loan_api.dao;

import com.geraud.ocr_loan_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User , Long> {

    Optional<User> findByEmailAndCardnumber(String email , String cardnumber);
}
