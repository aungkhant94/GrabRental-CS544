package com.grabrental.cs544.schedule.appservice;

import com.grabRental.cs544.dto.ScheduleDTO;
import com.grabRental.cs544.model.Schedule;

public interface IScheduleAppService {
	
	public ScheduleDTO createScheduleDTO(ScheduleDTO schedule);
}
