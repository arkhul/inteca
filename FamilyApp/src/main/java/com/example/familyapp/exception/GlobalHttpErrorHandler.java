package com.example.familyapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler {

    @ExceptionHandler(FamilyNotFoundException.class)
    public ResponseEntity<Object> handleFamilyNotFoundException() {
        return new ResponseEntity<>("A family with the given id number doesn't exist",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Object> handleInvalidInputException() {
        return new ResponseEntity<>("Incorrectly stated number of adults, children or infants",
                HttpStatus.BAD_REQUEST);
    }
}
