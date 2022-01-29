package com.grabRental.cs544.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grabRental.cs544.enumeration.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class ScheduleDTO {

	private Long id;

	@NotNull
	private Date date;

	private Date endDate;

	@NotNull
	private Integer durationInMinute;

	@NotNull
	private Integer noOfPassenger;

	@NotNull
	private Location source;

	@NotNull
	private Location destination;

	@NotNull
	private List<ServiceVehicleDTO> serviceVehicleList;


	public void addServiceVehicleList(VehicleDTO vehicle, DriverDTO driver){
		if(this.serviceVehicleList==null){
			this.serviceVehicleList = new ArrayList<>();
		}
		ServiceVehicleDTO serviceVehicle = new ServiceVehicleDTO( null);
		serviceVehicle.setVehicle(vehicle);
		serviceVehicle.setDriver(driver);
		this.serviceVehicleList.add(serviceVehicle);
	}

}
