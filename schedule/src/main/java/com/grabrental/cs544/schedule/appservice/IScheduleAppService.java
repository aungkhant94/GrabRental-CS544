package com.grabrental.cs544.schedule.appservice;

import com.grabRental.cs544.dto.ScheduleDTO;
import com.grabRental.cs544.model.Schedule;

import java.util.List;

public interface IScheduleAppService {
	
	 ScheduleDTO createScheduleDTO(ScheduleDTO schedule);
	 List<ScheduleDTO> getSchedules();
	 List<ScheduleDTO> getCalendarForDriver(Long driverId);
}
