package com.grabRental.cs544.converter;

import com.grabRental.cs544.dto.ServiceVehicleDTO;
import com.grabRental.cs544.model.ServiceVehicle;
import org.springframework.stereotype.Component;

@Component
public class ServiceVehicleConverter {

    public static ServiceVehicle toDao(ServiceVehicleDTO serviceVehicleDTO){
        ServiceVehicle serviceVehicle = new ServiceVehicle();
        serviceVehicle.setId(serviceVehicleDTO.getId());
        serviceVehicle.setVehicle(VehicleConverter.toDAO(serviceVehicleDTO.getVehicle()));


        return serviceVehicle;
    }

    public static ServiceVehicleDTO toDTO(ServiceVehicle serviceVehicle){
        ServiceVehicleDTO serviceVehicleDTO = new ServiceVehicleDTO();
        serviceVehicleDTO.setId(serviceVehicleDTO.getId());
        serviceVehicleDTO.setVehicle(VehicleConverter.toDTO(serviceVehicle.getVehicle()));
        return serviceVehicleDTO;
    }
}
