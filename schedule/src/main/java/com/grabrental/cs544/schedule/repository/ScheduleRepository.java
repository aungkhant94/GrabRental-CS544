package com.grabrental.cs544.schedule.repository;

import com.grabRental.cs544.model.ServiceVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import com.grabRental.cs544.model.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

    @Query(" SELECT COUNT(svh.id) FROM ServiceVehicle svh JOIN svh.schedule sch JOIN svh.vehicle v WHERE v.id = ?1 " +
            " AND ( sch.date BETWEEN ?2 AND ?3" +
            " OR sch.endDate BETWEEN ?2 AND ?3 )")
    public int getVehicleAppointmentCount(long vehicleId, @Temporal Date startTime,@Temporal Date endTime);

    @Query("SELECT DISTINCT sch FROM ServiceVehicle svh JOIN svh.schedule sch JOIN svh.driver d " +
            "WHERE  d.id = ?1 AND sch.date > ?2")
    public List<Schedule> getCalendarForDriver(Long driverId,@Temporal  Date date);

//    @Query("SELECT COUNT(svh.id) FROM ServiceVehicle svh JOIN svh.schedule sch JOIN svh.vehicle v WHERE v.id = ?1")
//    public int getVehicleAppointmentCount(long vehicleId, @Temporal Date startTime,@Temporal Date endTime);
}
