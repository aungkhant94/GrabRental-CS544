package com.grabRental.cs544.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    private String numberPlate;
    private String model;
    private String brand;
    private int modelYear;
    private int numberOfSeats;
    private String insuranceId;
    private Boolean pickUpSpace;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    public Vehicle(String numberPlate, String model, String brand, int modelYear, int numberOfSeats, String insuranceId, Boolean pickUpSpace, Date createdAt)
    {
        this.numberPlate = numberPlate;
        this.model = model;
        this.brand = brand;
        this.modelYear = modelYear;
        this.numberOfSeats = numberOfSeats;
        this.insuranceId = insuranceId;
        this.pickUpSpace = pickUpSpace;
        this.createdAt = createdAt;
    }
}
