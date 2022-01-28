package com.grabRental.cs544.dto;

import com.grabRental.cs544.enumeration.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long id;

    private String numberPlate;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String model;
    private String brand;
    private int modelYear;
    private int numberOfSeats;
    private String insuranceId;
    private Boolean pickUpSpace;
}
