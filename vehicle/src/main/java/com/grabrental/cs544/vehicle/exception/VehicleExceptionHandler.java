package com.grabrental.cs544.vehicle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class VehicleExceptionHandler {

    @ExceptionHandler(value = {VechicleApiException.class})
    public ResponseEntity<Object> handleVehicleException(VechicleApiException e){
        VehicleException vehicleException = new VehicleException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(vehicleException, HttpStatus.BAD_REQUEST);
    }
}
