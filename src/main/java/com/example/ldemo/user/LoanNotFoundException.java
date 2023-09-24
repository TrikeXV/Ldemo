package com.example.ldemo.user;

public class LoanNotFoundException extends Throwable {

    public LoanNotFoundException(String message) {
        super(message);
    }
}
