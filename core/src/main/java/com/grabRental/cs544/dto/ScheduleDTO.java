package com.grabRental.cs544.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grabRental.cs544.enumeration.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
public class ScheduleDTO {

	private Long id;

	private Date date;


	private Integer durationInMinute;

	private Integer noOfPassenger;

	private Location source;

	private Location destination;



	private List<ServiceVehicleDTO> serviceVehicleList;


	public void addServiceVehicleList(VehicleDTO vehicle, DriverDTO driver){
		if(this.serviceVehicleList==null){
			this.serviceVehicleList = new ArrayList<>();
		}
		ServiceVehicleDTO serviceVehicle = new ServiceVehicleDTO(this);
		serviceVehicle.setVehicle(vehicle);
		serviceVehicle.setDriver(driver);
		this.serviceVehicleList.add(serviceVehicle);

	}

}
