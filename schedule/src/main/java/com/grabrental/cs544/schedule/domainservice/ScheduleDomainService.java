package com.grabrental.cs544.schedule.domainservice;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.dto.VehicleDTO;
import com.grabRental.cs544.model.ServiceVehicle;
import com.grabRental.cs544.model.Vehicle;
import com.grabrental.cs544.schedule.exception.ScheduleApiException;
import com.grabrental.cs544.schedule.remoteservice.IDriverRemoteService;
import com.grabrental.cs544.schedule.remoteservice.IVehicleRemoteService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;

import com.grabRental.cs544.model.Schedule;
import com.grabrental.cs544.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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
        Calendar c = Calendar.getInstance();
        c.setTime(schedule.getDate());
        c.add(Calendar.MINUTE, schedule.getDurationInMinute());
        schedule.setEndDate(c.getTime());
       try {
            if (schedule.getServiceVehicleList() != null) {
                for (ServiceVehicle serviceVehicle : schedule.getServiceVehicleList()) {
                    if (serviceVehicle.getDriver() != null || serviceVehicle.getVehicle() != null) {


                        DriverDTO driverDTO = driverRemoteService.getDriverById(serviceVehicle.getDriver().getId());


                        VehicleDTO vehicleDTO = vehicleRemoteService.getVehicleById(serviceVehicle.getVehicle().getId());
                        if (driverDTO == null)
                            throw new ScheduleApiException("Drive Module not available right now");
                        if (vehicleDTO == null)
                            throw new ScheduleApiException("Vehicle Module not available right now");

                        int count = scheduleRepository.getVehicleAppointmentCount(vehicleDTO.getId(), schedule.getDate(), schedule.getEndDate());
                        if(count>0){
                            throw new ScheduleApiException("Vehicle Not Available Right Now. Booked by "+count+" appointment.");
                        }
                    }
                }
            }
        }catch (FeignException.BadRequest e){

            throw new ScheduleApiException("No Data Found "+e.getMessage());
        }



        return scheduleRepository.save(schedule);
    }


    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getCalendarForDriver(Long driverId){
       return scheduleRepository.getCalendarForDriver(driverId,new Date());
    }
}
