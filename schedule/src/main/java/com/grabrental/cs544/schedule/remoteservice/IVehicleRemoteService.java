package com.grabrental.cs544.schedule.remoteservice;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabRental.cs544.dto.VehicleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "vehicle", path = "/vehicles",
        fallback = VehicleRemoteFallBack.class)
public interface IVehicleRemoteService {

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    VehicleDTO getVehicleById(@PathVariable Long id);
}
