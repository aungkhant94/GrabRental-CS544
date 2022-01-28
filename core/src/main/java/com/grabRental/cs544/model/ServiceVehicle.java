package com.grabRental.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @JoinColumn
    private Schedule schedule;


    public ServiceVehicle(Schedule schedule){
        this.setSchedule(schedule);
    }


}
