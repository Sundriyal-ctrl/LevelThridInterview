package com.LevelThirdInterview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class PlayerIsAlreadyExitsException extends RuntimeException {
    public PlayerIsAlreadyExitsException(String s) {
        super(s);
    }
}
