package com.geraud.ocr_loan_api.services;

import com.geraud.ocr_loan_api.domain.User;
import com.geraud.ocr_loan_api.exceptions.NoUserFound;

public interface UserService {

    User findByEmail(String email) throws NoUserFound;
}
