package com.education.constitution.exception;

public class AccessTokenTakenException extends RuntimeException {
    public AccessTokenTakenException(String message) {
        super(message);
    }
}
