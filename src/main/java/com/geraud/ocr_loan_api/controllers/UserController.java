package com.geraud.ocr_loan_api.controllers;

import com.geraud.ocr_loan_api.domain.User;
import com.geraud.ocr_loan_api.exceptions.NoUserFound;
import com.geraud.ocr_loan_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user")
    public User getUser(@RequestParam(value = "email") String email ,
                        @RequestParam(value = "cardnumber") String cardnumber) {
        return userService.findByEmailAndCardNumber(email,cardnumber);
    }
}
