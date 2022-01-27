package com.grabrental.cs544.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabRental.cs544.model.Schedule;

public interface ScheduleRepsitory extends JpaRepository<Schedule, Long>{

}
