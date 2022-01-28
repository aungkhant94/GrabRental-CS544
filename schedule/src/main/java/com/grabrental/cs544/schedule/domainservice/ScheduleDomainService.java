package com.grabrental.cs544.schedule.domainservice;

import com.grabRental.cs544.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import com.grabRental.cs544.model.Schedule;
import com.grabrental.cs544.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleDomainService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {

    	return scheduleRepository.save(schedule);
    }


    public List<Schedule> getSchedules(){
        return scheduleRepository.findAll();
    }
}
