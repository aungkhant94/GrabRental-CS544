package com.grabrental.cs544.schedule.domainservice;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.dto.VehicleDTO;
import com.grabRental.cs544.model.ServiceVehicle;
import com.grabRental.cs544.model.Vehicle;
import com.grabrental.cs544.schedule.remoteservice.IDriverRemoteService;
import com.grabrental.cs544.schedule.remoteservice.IVehicleRemoteService;
import org.springframework.beans.factory.annotation.Autowired;

import com.grabRental.cs544.model.Schedule;
import com.grabrental.cs544.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleDomainService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    IDriverRemoteService driverRemoteService;

    @Autowired
    IVehicleRemoteService vehicleRemoteService;

    public Schedule createSchedule(Schedule schedule) {
        System.out.println("Schedule >>>>>>>>>>>>>>>>>");
        if (schedule.getServiceVehicleList() != null) {
            System.out.println("Service Vehicle >>>>>>>>>>>>>>>>>");
            for (ServiceVehicle serviceVehicle : schedule.getServiceVehicleList()) {
                if (serviceVehicle.getDriver() != null || serviceVehicle.getVehicle() != null) {
                    System.out.println("before Feign >>>>>>>>>>>>>>>>>");
                    DriverDTO driverDTO = driverRemoteService.getDriverById(serviceVehicle.getDriver().getId());
                    VehicleDTO vehicleDTO = vehicleRemoteService.getVehicleById(serviceVehicle.getVehicle().getId());
                    System.out.println(driverDTO.getFirstName() + ">>>>>>>>>>>>>>>>>");
                    System.out.println(vehicleDTO.getBrand() + ">>>>>>>>>>>>>>>>>");
                }
            }
        }

        return scheduleRepository.save(schedule);
    }


    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }
}
