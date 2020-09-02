package com.geraud.ocr_loan_api.exceptions;

public class NoUserFound extends Exception{

    public NoUserFound() {
    }

    public NoUserFound(String message) {
        super(message);
    }

    public NoUserFound(String message, Throwable cause) {
        super(message, cause);
    }
}
