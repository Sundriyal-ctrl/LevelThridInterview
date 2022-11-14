package com.LevelThirdInterview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class gameIsAlreadyExitsException extends RuntimeException{
    public gameIsAlreadyExitsException(String message) {
        super(message);
    }
}
