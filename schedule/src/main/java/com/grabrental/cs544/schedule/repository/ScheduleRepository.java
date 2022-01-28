package com.grabrental.cs544.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabRental.cs544.model.Schedule;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
