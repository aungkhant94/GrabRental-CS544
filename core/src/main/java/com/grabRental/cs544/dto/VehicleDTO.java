package com.grabRental.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private String numberPlate;
    private String model;
    private String brand;
    private int modelYear;
    private int numberOfSeats;
    private String insuranceId;
    private Boolean pickUpSpace;
}
