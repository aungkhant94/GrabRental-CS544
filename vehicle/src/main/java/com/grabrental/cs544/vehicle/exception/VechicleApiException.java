package com.grabrental.cs544.vehicle.exception;

public class VechicleApiException extends RuntimeException{
    public VechicleApiException(String message) {
        super(message);
    }

    public VechicleApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
