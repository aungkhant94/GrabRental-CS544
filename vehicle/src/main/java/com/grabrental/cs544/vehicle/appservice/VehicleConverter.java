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
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setType(vehicleDTO.getType());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setInsuranceId(vehicleDTO.getInsuranceId());
        vehicle.setModelYear(vehicleDTO.getModelYear());
        vehicle.setNumberOfSeats(vehicleDTO.getNumberOfSeats());
        vehicle.setPickUpSpace(vehicleDTO.getPickUpSpace());
        vehicle.setNumberPlate(vehicleDTO.getNumberPlate());
        return vehicle;
    }


    public VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setType(vehicle.getType());
        vehicleDTO.setInsuranceId(vehicle.getInsuranceId());
        vehicleDTO.setModelYear(vehicle.getModelYear());
        vehicleDTO.setNumberPlate(vehicle.getNumberPlate());
        vehicleDTO.setNumberOfSeats(vehicle.getNumberOfSeats());
        vehicleDTO.setPickUpSpace(vehicle.getPickUpSpace());
        return vehicleDTO;
    }
}
