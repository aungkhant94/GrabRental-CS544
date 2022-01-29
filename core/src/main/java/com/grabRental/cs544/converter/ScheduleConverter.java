package com.grabRental.cs544.converter;

import com.grabRental.cs544.dto.ScheduleDTO;
import com.grabRental.cs544.dto.ServiceVehicleDTO;
import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.ServiceVehicle;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConverter {

	public static Schedule toDAO(ScheduleDTO scheduleDTO) {
		Schedule schedule = new Schedule();
		schedule.setId(scheduleDTO.getId());
		schedule.setDate(scheduleDTO.getDate());
		schedule.setEndDate(scheduleDTO.getEndDate());
		schedule.setDestination(scheduleDTO.getDestination());
		schedule.setSource(scheduleDTO.getSource());
		schedule.setDurationInMinute(scheduleDTO.getDurationInMinute());
		schedule.setNoOfPassenger(scheduleDTO.getNoOfPassenger());
		if(scheduleDTO.getServiceVehicleList()!=null && scheduleDTO.getServiceVehicleList().size()>0){
			for(ServiceVehicleDTO serviceVehicleDTO: scheduleDTO.getServiceVehicleList()){
			 ServiceVehicle serviceVehicle = ServiceVehicleConverter.toDao(serviceVehicleDTO);
			 schedule.addServiceVehicleList(serviceVehicle.getVehicle(),serviceVehicle.getDriver());
			}

		}
		return schedule;
	}
	
	
	public static ScheduleDTO toDTO(Schedule schedule) {


		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setId(schedule.getId());
		scheduleDTO.setDate(schedule.getDate());
		scheduleDTO.setEndDate(schedule.getEndDate());
		scheduleDTO.setDestination(schedule.getDestination());
		scheduleDTO.setSource(schedule.getSource());
		scheduleDTO.setDurationInMinute(schedule.getDurationInMinute());
		scheduleDTO.setNoOfPassenger(schedule.getNoOfPassenger());
		if(schedule.getServiceVehicleList()!=null && schedule.getServiceVehicleList().size()>0){
			for(ServiceVehicle serviceVehicle: schedule.getServiceVehicleList()){
				ServiceVehicleDTO serviceVehicleDTO = ServiceVehicleConverter.toDTO(serviceVehicle);
				scheduleDTO.addServiceVehicleList(serviceVehicleDTO.getVehicle(),serviceVehicleDTO.getDriver());
			}

		}
		
		return scheduleDTO;
	}
}
