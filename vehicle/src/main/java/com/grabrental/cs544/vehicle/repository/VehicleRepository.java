package com.grabrental.cs544.vehicle.repository;

import com.grabRental.cs544.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

     @Query("SELECT v FROM ServiceVehicle s JOIN s.schedule sch JOIN s.vehicle v " +
             "WHERE (sch.date = ?1 AND sch.endDate = ?2)")
     List<Vehicle> getAvailableVehicles(@Temporal Date startTime, @Temporal Date endTime);
}
