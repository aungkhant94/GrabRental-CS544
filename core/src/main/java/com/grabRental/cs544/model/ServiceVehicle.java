package com.grabRental.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ServiceVehicle {

    @Id
    @GeneratedValue
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
