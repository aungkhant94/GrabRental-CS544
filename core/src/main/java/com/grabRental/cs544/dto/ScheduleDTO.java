package com.grabRental.cs544.dto;

import java.util.Date;

import com.grabRental.cs544.enumeration.Location;

public class ScheduleDTO {

	private Long id;
	
	private Date date;
	
	
	private Integer durationInMinute;
	
	private Integer noOfPassenger;
	
	private Location source;
	
	private Location destination;
}
