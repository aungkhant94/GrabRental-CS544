package com.grabrental.cs544.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grabrental.cs544.schedule.appservice.IScheduleAppService;

@Controller
public class ScheduleController {

	@Autowired
	IScheduleAppService scheduleAppService;
	
	
}
