package com.grabrental.cs544.vehicle.domainservice;

import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.Vehicle;
import com.grabrental.cs544.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleDomainService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
