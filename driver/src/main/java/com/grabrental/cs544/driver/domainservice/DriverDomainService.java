package com.grabrental.cs544.driver.domainservice;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.model.Driver;
import com.grabRental.cs544.model.Vehicle;
import com.grabrental.cs544.driver.exception.DriverApiException;
import com.grabrental.cs544.driver.exception.DriverException;
import com.grabrental.cs544.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverDomainService extends Exception {

    @Autowired
    DriverRepository driverRepository;

    public Driver save(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver get(long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if(driver.isPresent()){
            return driver.get();
        }
        throw new DriverApiException("Not Found");
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Driver update(Driver driver) {
        if(driverRepository.findById(driver.getId()).isPresent()){
            return driverRepository.save(driver);
        }
       throw new DriverApiException("Not Found");
    }

    public Long delete(long id) {

        if(driverRepository.findById(id).isPresent()){
            driverRepository.deleteById(id);
            return id;
        }
        throw new DriverApiException("Not Found");
    }

    public List<Driver> getAvailableDrivers(Date startTime, Date endTime) {
        List<Driver> availableDrivers = driverRepository.getAvailableDrivers(startTime, endTime);
        if(availableDrivers.size() <= 0){
            throw new DriverApiException("No available drivers at the moment");
        }else {
            return availableDrivers;
        }
    }
}
