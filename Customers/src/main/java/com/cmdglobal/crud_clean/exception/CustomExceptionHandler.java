package com.cmdglobal.crud_clean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse ExceptionNotFound(NotFoundException ex, WebRequest req){
        return new ExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }
}
