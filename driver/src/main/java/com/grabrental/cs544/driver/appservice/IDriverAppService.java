package com.grabrental.cs544.driver.appservice;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.dto.ScheduleDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDriverAppService {

    DriverDTO save(DriverDTO driverDTO);

    DriverDTO get(long id);

    List<DriverDTO> getAll();

    DriverDTO update(DriverDTO driverDTO, long id);

    Long delete(long id);
}
