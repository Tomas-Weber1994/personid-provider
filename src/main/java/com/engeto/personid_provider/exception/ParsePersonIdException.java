package com.engeto.personid_provider.exception;

public class ParsePersonIdException extends RuntimeException {

    public ParsePersonIdException(String message) {
        super(message);
    }

    public ParsePersonIdException(String message, Throwable cause) {
        super(message, cause);
    }
}