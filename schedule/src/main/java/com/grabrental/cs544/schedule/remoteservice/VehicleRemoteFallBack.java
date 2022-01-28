package com.grabrental.cs544.schedule.remoteservice;

import com.grabRental.cs544.dto.VehicleDTO;

public class VehicleRemoteFallBack implements IVehicleRemoteService{
    @Override
    public VehicleDTO getVehicleById(Long id) {
        return null;
    }
}
