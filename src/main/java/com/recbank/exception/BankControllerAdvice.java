package com.recbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice(basePackages = "com.efficient.controller")
public class BankControllerAdvice {
    @ResponseBody
    @ExceptionHandler(BankNotFoundException.class)
    public ResponseEntity<BankExceptionHandler> BankNotFound(BankNotFoundException bankNotFoundException){
        BankExceptionHandler error = new BankExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Bank not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
