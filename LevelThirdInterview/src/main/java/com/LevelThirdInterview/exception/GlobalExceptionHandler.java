package com.LevelThirdInterview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(gameIsAlreadyExitsException.class)
    public ResponseEntity gameIsAlreadyExits(gameIsAlreadyExitsException gameIsAlreadyExitsException)
    {
        List<String> list=new ArrayList<>();
        list.add(gameIsAlreadyExitsException.getMessage());
        ErrorResponseHandler errorResponseHandler=new ErrorResponseHandler(gameIsAlreadyExitsException.getMessage(),list);
      return new ResponseEntity(Optional.of(errorResponseHandler), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(OponentIsAlreadyInYourCoordinate.class)
    public ResponseEntity OponentIsAlreadyInYourCoordinate(OponentIsAlreadyInYourCoordinate oponentIsAlreadyInYourCoordinate)
    {
        List<String> list=new ArrayList<>();
        list.add(oponentIsAlreadyInYourCoordinate.getMessage());
        ErrorResponseHandler errorResponseHandler=new ErrorResponseHandler(oponentIsAlreadyInYourCoordinate.getMessage(),list);
        return new ResponseEntity(Optional.of(errorResponseHandler), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity AnyExceptiom(Exception exception)
    {
        List<String> list=new ArrayList<>();
        list.add(exception.getMessage());
        ErrorResponseHandler errorResponseHandler=new ErrorResponseHandler(exception.getMessage(),list);
        return new ResponseEntity(Optional.of(errorResponseHandler), HttpStatus.ALREADY_REPORTED);
    }



}
