package com.geraud.ocr_loan_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "Utilisateur non trouvé")
public class NoUserFound extends RuntimeException{

    public NoUserFound() {
    }

    public NoUserFound(String message) {
        super(message);
    }

    public NoUserFound(String message, Throwable cause) {
        super(message, cause);
    }
}
