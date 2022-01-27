package com.grabrental.cs544.vehicle.controller;

import com.grabrental.cs544.vehicle.appservice.IVehicleAppService;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleController {
    @Autowired
    private IVehicleAppService vehicleAppService;
}
