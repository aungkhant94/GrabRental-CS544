package com.grabrental.cs544.vehicle.appservice;

import com.grabRental.cs544.dto.VehicleDTO;
import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.Vehicle;
import com.grabrental.cs544.vehicle.domainservice.VehicleDomainService;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleAppService implements IVehicleAppService{

    @Autowired
    private VehicleDomainService vehicleDomainService;

    @Autowired
    private VehicleConverter vehicleConverter;

    @Override
    public VehicleDTO createScheduleDTO(VehicleDTO vehicleDTO) {
        Vehicle vehicleToSave = vehicleConverter.toDAO(vehicleDTO);
        vehicleToSave =  vehicleDomainService.createVehicle(vehicleToSave);
        return vehicleConverter.toDTO(vehicleToSave);
    }
}
