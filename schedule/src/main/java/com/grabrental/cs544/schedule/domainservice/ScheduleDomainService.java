package com.grabrental.cs544.schedule.domainservice;

import org.springframework.beans.factory.annotation.Autowired;

import com.grabRental.cs544.model.Schedule;
import com.grabrental.cs544.schedule.repository.ScheduleRepsitory;

public class ScheduleDomainService {

	@Autowired
	ScheduleRepsitory scheduleRepsitory;
	
	public Schedule createSchedule(Schedule schedule) {
		return scheduleRepsitory.save(schedule);
	}
	
}
