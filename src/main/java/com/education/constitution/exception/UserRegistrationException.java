package com.education.constitution.exception;

public class UserRegistrationException extends RuntimeException {
    private boolean isBadRequest;

    public UserRegistrationException(String message) {
        super(message);
    }
}