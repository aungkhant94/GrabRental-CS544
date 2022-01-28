package com.grabRental.cs544.converter;

import com.grabRental.cs544.dto.ServiceVehicleDTO;
import com.grabRental.cs544.model.ServiceVehicle;

public class ServiceVehicleConverter {

    public static ServiceVehicle toDao(ServiceVehicleDTO serviceVehicleDTO){
        ServiceVehicle serviceVehicle = new ServiceVehicle();
        serviceVehicle.setId(serviceVehicleDTO.getId());
        serviceVehicle.setVehicle(VehicleConverter.toDAO(serviceVehicleDTO.getVehicle()));


        return serviceVehicle;
    }

    public ServiceVehicle toDTO(ServiceVehicleDTO serviceVehicleDTO){
        ServiceVehicle serviceVehicle = new ServiceVehicle();
        serviceVehicle.setId(serviceVehicleDTO.getId());
        serviceVehicle.setVehicle(VehicleConverter.toDAO(serviceVehicleDTO.getVehicle()));
        return serviceVehicle;
    }
}
