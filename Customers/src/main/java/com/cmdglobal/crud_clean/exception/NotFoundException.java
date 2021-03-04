package com.cmdglobal.crud_clean.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
