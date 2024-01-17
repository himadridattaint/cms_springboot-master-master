package com.cms_springboot.cms_springboot.exception;

import com.cms_springboot.cms_springboot.CResponse.CResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CResponse> handleUserNotFoundException(UserNotFoundException ex)
    {

        CResponse response = new CResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
