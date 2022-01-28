package com.grabrental.cs544.vehicle.appservice;

import com.grabRental.cs544.dto.VehicleDTO;

import java.util.List;

public interface IVehicleAppService {
    List<VehicleDTO> getVehicles();
    VehicleDTO getVehicleById(Long id);
    VehicleDTO createVehicleDTO(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDTO);
    void deleteVehicle(Long id);
}
