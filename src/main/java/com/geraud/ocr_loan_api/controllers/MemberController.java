package com.geraud.ocr_loan_api.controllers;

import com.geraud.ocr_loan_api.domain.Member;
import com.geraud.ocr_loan_api.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/user")
    public Member getUser(@RequestParam(value = "email") String email ,
                          @RequestParam(value = "cardnumber") String cardnumber) {
        return memberService.findByEmailAndCardNumber(email,cardnumber);
    }
}
