package com.grabRental.cs544.model;

import com.grabRental.cs544.dto.DriverDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class ServiceVehicle {

    @Id
    private Long id;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Schedule schedule;

    public ServiceVehicle(Schedule schedule){
        this.schedule = schedule;
    }
}
