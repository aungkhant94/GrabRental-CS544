package com.grabrental.cs544.driver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class DriverExceptionHandler {

    @ExceptionHandler(value = {DriverApiException.class})
    public ResponseEntity<Object> handleDriverException(DriverApiException e){
        DriverException vehicleException = new DriverException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(vehicleException, HttpStatus.BAD_REQUEST);
    }
}
