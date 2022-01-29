package com.grabrental.cs544.schedule.appservice;

import com.grabRental.cs544.converter.ScheduleConverter;
import com.grabRental.cs544.dto.VehicleDTO;
import com.grabrental.cs544.schedule.exception.ScheduleApiException;
import org.springframework.beans.factory.annotation.Autowired;

import com.grabRental.cs544.dto.ScheduleDTO;
import com.grabRental.cs544.model.Schedule;
import com.grabrental.cs544.schedule.domainservice.ScheduleDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchdeuleAppService implements  IScheduleAppService{

	@Autowired
	ScheduleDomainService scheduleDomainService;
	

	@Override
	public ScheduleDTO createScheduleDTO(ScheduleDTO schedule) {
		Schedule scheduleToSave = ScheduleConverter.toDAO(schedule);
		Schedule newSchedule;
		if(schedule.getServiceVehicleList()==null ||
			schedule.getServiceVehicleList().size()<=0
		){
			throw new ScheduleApiException("ServiceVehicle List shouldn't be empty!!");
		}else {
			newSchedule = scheduleDomainService.createSchedule(scheduleToSave);
		}
		return ScheduleConverter.toDTO(newSchedule);
	}

	@Override
	public List<ScheduleDTO> getSchedules() {
		List<Schedule> scheduleList = scheduleDomainService.getSchedules();
		List<ScheduleDTO> scheduleDTOList =  scheduleList.stream()
				.map(vehicle -> ScheduleConverter.toDTO(vehicle))
				.collect(Collectors.toList());
		return scheduleDTOList;

	}

}
