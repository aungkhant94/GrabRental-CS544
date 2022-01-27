package com.grabrental.cs544.schdule.appservice;

import org.springframework.beans.factory.annotation.Autowired;

import com.grabRental.cs544.dto.ScheduleDTO;
import com.grabRental.cs544.model.Schedule;
import com.grabrental.cs544.schedule.domainservice.ScheduleDomainService;

public class SchdeuleAppService implements  IScheduleAppService{

	@Autowired
	ScheduleDomainService scheduleDomainService;
	
	@Autowired
	ScheduleConverter scheduleConverter;
	
	@Override
	public ScheduleDTO createScheduleDTO(ScheduleDTO schedule) {
		Schedule scheduleToSave = scheduleConverter.toDAO(schedule);
		scheduleToSave =  scheduleDomainService.createSchedule(scheduleToSave);
		return scheduleConverter.toDTO(scheduleToSave);
	}

}
