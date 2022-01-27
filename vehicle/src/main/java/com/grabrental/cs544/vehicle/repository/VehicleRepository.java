package com.grabrental.cs544.vehicle.repository;

import com.grabRental.cs544.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
