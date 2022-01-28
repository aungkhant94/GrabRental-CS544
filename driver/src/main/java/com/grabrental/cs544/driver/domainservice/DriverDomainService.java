package com.grabrental.cs544.driver.domainservice;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.model.Driver;
import com.grabrental.cs544.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverDomainService extends Exception {

    @Autowired
    DriverRepository driverRepository;

    public Driver save(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver get(long id) {
        return driverRepository.findById(id).get();
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Driver update(Driver driver) {
        if(driverRepository.findById(driver.getId()).isPresent()){
            return driverRepository.save(driver);
        }
       return null;
    }

    public Long delete(long id) {

        if(driverRepository.findById(id).isPresent()){
            driverRepository.deleteById(id);
            return id;
        }
        return -1L;
    }
}
