package com.grabrental.cs544.schedule.remoteservice;

import com.grabRental.cs544.dto.DriverDTO;

public class DriverRemoteFallBack implements IDriverRemoteService{

    @Override
    public DriverDTO getDriverById(Long id) {
        return null;
    }
}
