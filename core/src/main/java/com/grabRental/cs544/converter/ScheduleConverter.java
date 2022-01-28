package com.grabRental.cs544.converter;

import com.grabRental.cs544.dto.ScheduleDTO;
import com.grabRental.cs544.dto.ServiceVehicleDTO;
import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.ServiceVehicle;

public class ScheduleConverter {

	public Schedule toDAO(ScheduleDTO scheduleDTO) {
		Schedule schedule = new Schedule();
		schedule.setId(scheduleDTO.getId());
		schedule.setDate(scheduleDTO.getDate());
		schedule.setDestination(scheduleDTO.getDestination());
		schedule.setSource(scheduleDTO.getSource());
		schedule.setDurationInMinute(scheduleDTO.getDurationInMinute());
		schedule.setNoOfPassenger(scheduleDTO.getNoOfPassenger());
		if(scheduleDTO.getServiceVehicleList()!=null && scheduleDTO.getServiceVehicleList().size()>0){
			for(ServiceVehicleDTO serviceVehicleDTO: scheduleDTO.getServiceVehicleList()){
				//converter
			}

		}
		return schedule;
	}
	
	
	public ScheduleDTO toDTO(Schedule schedule) {


		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setId(schedule.getId());
		scheduleDTO.setDate(schedule.getDate());
		scheduleDTO.setDestination(schedule.getDestination());
		scheduleDTO.setSource(schedule.getSource());
		scheduleDTO.setDurationInMinute(schedule.getDurationInMinute());
		scheduleDTO.setNoOfPassenger(schedule.getNoOfPassenger());
		if(schedule.getServiceVehicleList()!=null && schedule.getServiceVehicleList().size()>0){
			for(ServiceVehicle serviceVehicle: schedule.getServiceVehicleList()){
				//converter
			}

		}
		
		return scheduleDTO;
	}
}
