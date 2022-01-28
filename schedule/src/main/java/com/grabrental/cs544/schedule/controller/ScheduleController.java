package com.grabrental.cs544.schedule.controller;

import com.grabRental.cs544.dto.ScheduleDTO;
import com.grabRental.cs544.dto.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.grabrental.cs544.schedule.appservice.IScheduleAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

	@Autowired
	IScheduleAppService scheduleAppService;

	@GetMapping
	public ResponseEntity<List<ScheduleDTO>> getVehicles() {

		return ResponseEntity.ok(scheduleAppService.getSchedules());
	}

	@PostMapping
	public ScheduleDTO createVehicle(@RequestBody ScheduleDTO scheduleDTO){
		ScheduleDTO scheduleDTOToSave = scheduleAppService.createScheduleDTO(scheduleDTO);
		return scheduleDTOToSave;
	}
}
