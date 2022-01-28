package com.grabrental.cs544.driver.exception;

public class DriverApiException extends RuntimeException{
    public DriverApiException(String message) {
        super(message);
    }

    public DriverApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
