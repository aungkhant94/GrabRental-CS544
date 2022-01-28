package com.grabrental.cs544.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ScheduleExceptionHandler {

    @ExceptionHandler(value = {ScheduleApiException.class})
    public ResponseEntity<Object> handleScheduleException(ScheduleApiException e){
        ScheduleException vehicleException = new ScheduleException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(vehicleException, HttpStatus.BAD_REQUEST);
    }
}
