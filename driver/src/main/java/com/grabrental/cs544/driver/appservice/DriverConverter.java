package com.grabrental.cs544.driver.appservice;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.model.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverConverter {

    public static Driver toDAO(DriverDTO driverDTO){

        return new Driver(driverDTO.getFirstName(),
                driverDTO.getLastname(),
                driverDTO.getAge(),
                driverDTO.getAddress(),
                driverDTO.getLicenseId(),
                driverDTO.getExperience());
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
