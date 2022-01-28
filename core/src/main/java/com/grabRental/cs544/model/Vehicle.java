package com.grabRental.cs544.model;

import javax.persistence.Entity;

import com.grabRental.cs544.enumeration.VehicleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String numberPlate;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @NotBlank
    private String model;

    @NotBlank
    private String brand;

    @NotNull
    private int modelYear;

    @NotNull
    private int numberOfSeats;

    @NotBlank
    private String insuranceId;
    private Boolean pickUpSpace;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    public Vehicle(String numberPlate, VehicleType type, String model, String brand, int modelYear, int numberOfSeats, String insuranceId, Boolean pickUpSpace, Date createdAt)
    {
        this.numberPlate = numberPlate;
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.modelYear = modelYear;
        this.numberOfSeats = numberOfSeats;
        this.insuranceId = insuranceId;
        this.pickUpSpace = pickUpSpace;
        this.createdAt = createdAt;
    }
}
