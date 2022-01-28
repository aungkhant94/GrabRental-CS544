package com.grabRental.cs544.model;

import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.grabRental.cs544.enumeration.Location;

@Entity
public class Schedule {
	
	@Id
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
	private Integer durationInMinute;
	
	private Integer noOfPassenger;
	
	@Enumerated(EnumType.STRING)
	private Location source;
	
	@Enumerated(EnumType.STRING)
	private Location destination;
	

}
