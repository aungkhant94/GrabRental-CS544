package com.grabrental.cs544.vehicle.domainservice;

import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.Vehicle;
import com.grabrental.cs544.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleDomainService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isPresent()){
            return vehicle.get();
        }
        return null;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle){
        Optional<Vehicle> vehicleToUpdate = vehicleRepository.findById(id);
        if(vehicleToUpdate.isPresent()){
            vehicle.setId(id);
            vehicleRepository.save(vehicle);
            return vehicle;
        }
        return null;
    }

    public void deleteVehicle(Long id){
        Optional<Vehicle> vehicleToDelete = vehicleRepository.findById(id);
        if(vehicleToDelete.isPresent()){
            vehicleRepository.delete(vehicleToDelete.get());
        }
    }
}