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

     /**
      * Query to retrieve all the availabel vehicles between a time frame
      * @param startTime
      * @param endTime
      * @return
      */
     @Query("SELECT ve FROM Vehicle ve WHERE ve.id NOT IN" +
             "(SELECT v.id FROM ServiceVehicle svh JOIN svh.schedule sc JOIN svh.vehicle v " +
             "WHERE(sc.date BETWEEN ?1 AND ?2)" +
             "OR sc.endDate BETWEEN ?1 AND ?2)")
     List<Vehicle> getAvailableVehicles(@Temporal Date startTime, @Temporal Date endTime);
}
