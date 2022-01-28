package com.grabRental.cs544.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grabRental.cs544.enumeration.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;


	private Integer durationInMinute;

	private Integer noOfPassenger;

	@Enumerated(EnumType.STRING)
	private Location source;

	@Enumerated(EnumType.STRING)
	private Location destination;

	@OneToMany(mappedBy = "schedule")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<ServiceVehicle> serviceVehicleList;


	public void addServiceVehicleList(Vehicle vehicle, Driver driver){
		if(this.serviceVehicleList==null){
			this.serviceVehicleList = new ArrayList<>();
		}
		ServiceVehicle serviceVehicle = new ServiceVehicle(this);
		serviceVehicle.setVehicle(vehicle);
		serviceVehicle.setDriver(driver);
		this.serviceVehicleList.add(serviceVehicle);

	}
	

}
