package com.grabrental.cs544.schedule.remoteservice;


import com.grabRental.cs544.dto.DriverDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Eurika name / api path
@FeignClient(name = "driver", path = "/drivers",
        fallback = DriverRemoteFallBack.class)
public interface IDriverRemoteService {

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    DriverDTO getDriverById(@PathVariable Long id);

}