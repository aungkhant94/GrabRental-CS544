package com.grabrental.cs544.vehicle.appservice;

import com.grabRental.cs544.dto.ScheduleDTO;
import com.grabRental.cs544.dto.VehicleDTO;
import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleConverter {
    public Vehicle toDAO(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();


        return vehicle;
    }


    public VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();




        return vehicleDTO;
    }
}
