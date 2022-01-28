package com.grabRental.cs544.dto;

import com.grabRental.cs544.model.Driver;
import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.Vehicle;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class ServiceVehicleDTO {


    private Long id;


    private DriverDTO driver;


    private VehicleDTO vehicle;

    private ScheduleDTO schedule;


    public ServiceVehicleDTO(ScheduleDTO schedule){
        this.setSchedule(schedule);
    }


}
