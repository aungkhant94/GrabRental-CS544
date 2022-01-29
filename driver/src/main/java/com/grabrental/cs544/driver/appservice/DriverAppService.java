package com.grabrental.cs544.driver.appservice;

import com.grabRental.cs544.converter.DriverConverter;
import com.grabRental.cs544.converter.VehicleConverter;
import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.model.Driver;
import com.grabrental.cs544.driver.domainservice.DriverDomainService;
import com.grabrental.cs544.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DriverAppService implements IDriverAppService {


    @Autowired
    DriverDomainService driverDomainService;

    @Override
    public DriverDTO save(DriverDTO driverDTO) {

        Driver driver = driverDomainService.save(DriverConverter.toDAO(driverDTO));
        return DriverConverter.toDTO(driver);
    }

    @Override
    public DriverDTO get(long id) {
        return DriverConverter.toDTO(driverDomainService.get(id));
    }

    @Override
    public List<DriverDTO> getAll() {
        return  driverDomainService.getAll().
                stream().map( x -> DriverConverter.toDTO(x)).
                collect(Collectors.toList());
    }

    @Override
    public DriverDTO update(DriverDTO driverDTO, long id) {

        Driver driverInsert = DriverConverter.toDAO(driverDTO);
        driverInsert.setId(id);
        Driver driver = driverDomainService.update(driverInsert);
        return DriverConverter.toDTO(driver);
    }

    @Override
    public Long delete(long id) {
        return driverDomainService.delete(id);
    }

    @Override
    public List<DriverDTO> getAvailableDrivers(Date startTime, Date endTime) {
        return driverDomainService.getAvailableDrivers(startTime, endTime)
                .stream()
                .map(driver -> DriverConverter.toDTO(driver))
                .collect(Collectors.toList());
    }

}
