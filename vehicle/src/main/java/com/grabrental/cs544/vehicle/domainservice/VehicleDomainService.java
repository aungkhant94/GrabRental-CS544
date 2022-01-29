package com.grabrental.cs544.vehicle.domainservice;

import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.Vehicle;
import com.grabrental.cs544.vehicle.exception.VechicleApiException;
import com.grabrental.cs544.vehicle.exception.VehicleExceptionHandler;
import com.grabrental.cs544.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleDomainService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(){
       if(vehicleRepository.findAll().size() <= 0){
           throw new VechicleApiException("No vehicle found");
       }
       return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isPresent()){
            return vehicle.get();
        }
        throw new VechicleApiException("No vehicle found");
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
        throw new VechicleApiException("No vehicle found");
    }

    public void deleteVehicle(Long id){
        Optional<Vehicle> vehicleToDelete = vehicleRepository.findById(id);
        if(vehicleToDelete.isPresent()){
            vehicleRepository.delete(vehicleToDelete.get());
        }
        else {
            throw new VechicleApiException("No vehicle found");
        }
    }

    /**
     * Retrieve all the available vehicles between a time frame
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Vehicle> getAvailableVehicles(Date startTime, Date endTime){
       // List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<Vehicle> availableVehicles = vehicleRepository.getAvailableVehicles(startTime, endTime);
       // List<Vehicle> availableVehicles = new ArrayList<>();

        if(availableVehicles.size() <= 0){
            throw new VechicleApiException("No available vehicles at the moment");
        }else {
            return availableVehicles;
        }
    }
}
