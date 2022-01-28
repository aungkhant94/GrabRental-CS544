package com.grabRental.cs544.converter;

import com.grabRental.cs544.dto.ServiceVehicleDTO;
import com.grabRental.cs544.model.ServiceVehicle;
import org.springframework.stereotype.Component;

@Component
public class ServiceVehicleConverter {

    public static ServiceVehicle toDao(ServiceVehicleDTO serviceVehicleDTO){
        ServiceVehicle serviceVehicle = new ServiceVehicle();
        serviceVehicle.setId(serviceVehicleDTO.getId());
        if(serviceVehicleDTO.getVehicle()!=null) {
            serviceVehicle.setVehicle(VehicleConverter.toDAO(serviceVehicleDTO.getVehicle()));
        }
        if(serviceVehicleDTO.getDriver()!=null){
            serviceVehicle.setDriver(DriverConverter.toDAO(serviceVehicleDTO.getDriver()));
        }


        return serviceVehicle;
    }

    public static ServiceVehicleDTO toDTO(ServiceVehicle serviceVehicle){
        ServiceVehicleDTO serviceVehicleDTO = new ServiceVehicleDTO();
        serviceVehicleDTO.setId(serviceVehicleDTO.getId());
        if(serviceVehicle.getVehicle()!=null) {
            serviceVehicleDTO.setVehicle(VehicleConverter.toDTO(serviceVehicle.getVehicle()));
        }
        if(serviceVehicle.getDriver()!=null){
            serviceVehicleDTO.setDriver(DriverConverter.toDTO(serviceVehicle.getDriver()));
        }
        return serviceVehicleDTO;
    }
}
