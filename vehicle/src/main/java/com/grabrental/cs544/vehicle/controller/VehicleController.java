package com.grabrental.cs544.vehicle.controller;

import com.grabRental.cs544.dto.VehicleDTO;
import com.grabrental.cs544.vehicle.appservice.IVehicleAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private IVehicleAppService vehicleAppService;

    @PostMapping
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO){
         VehicleDTO vehicleDTO1 = vehicleAppService.createVehicleDTO(vehicleDTO);
         return vehicleDTO1;
    }


}
