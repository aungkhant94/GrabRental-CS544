package com.grabRental.cs544.converter;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.model.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverConverter {

    public static Driver toDAO(DriverDTO driverDTO){
        Driver driver  = new Driver(driverDTO.getFirstName(),
                driverDTO.getLastname(),
                driverDTO.getAge(),
                driverDTO.getAddress(),
                driverDTO.getLicenseId(),
                driverDTO.getExperience());
        driver.setId(driverDTO.getId());
        return driver;
    }

    public static DriverDTO toDTO(Driver driver){

        return new DriverDTO(driver.getId(),
                driver.getFirstName(),
                driver.getLastname(),
                driver.getAge(),
                driver.getAddress(),
                driver.getLicenseId(),
                driver.getExperience());
    }

}
