package com.javafee.springdemo.exception;

public class NumberRangeException extends NumberFormatException {
    public NumberRangeException(String message) {
        super(message);
    }
}
