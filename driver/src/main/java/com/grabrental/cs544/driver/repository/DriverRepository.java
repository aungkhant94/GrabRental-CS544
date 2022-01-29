package com.grabrental.cs544.driver.repository;

import com.grabRental.cs544.model.Driver;
import com.grabRental.cs544.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query(value = "select * from driver d1 where d1.id not in " +
            "(select svh.vehicle_id from service_vehicle svh  " +
            "join driver d2 on d2.id = svh.vehicle_id " +
            "join schedule sch on sch.id = svh.schedule_id " +
            "where sch.date BETWEEN ?1 AND ?2 " +
            "OR sch.end_date BETWEEN ?1 AND ?2) ", nativeQuery = true)
    List<Driver> getAvailableDrivers(@Temporal Date startTime, @Temporal Date endTime);
}
