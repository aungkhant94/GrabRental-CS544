package com.grabrental.cs544.vehicle.controller;

import com.grabRental.cs544.dto.VehicleDTO;
import com.grabrental.cs544.vehicle.appservice.IVehicleAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    /**
     * Injecting vehicleService
     */
    @Autowired
    private IVehicleAppService vehicleAppService;

    /**
     * retreive all the vehicles from database
     * @return
     */
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getVehicles(){
        return ResponseEntity.ok(vehicleAppService.getVehicles());
    }

    /**
     * retrieve vechile by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleAppService.getVehicleById(id));
    }

    /**
     * save vehicle to db
     * @param vehicleDTO
     * @return
     */
    @PostMapping
    public VehicleDTO createVehicle(@RequestBody VehicleDTO vehicleDTO){
         VehicleDTO vehicleDTOToSave = vehicleAppService.createVehicleDTO(vehicleDTO);
         return vehicleDTOToSave;
    }

    /**
     * update vehicle of particular id
     * @param id
     * @param vehicleDTO
     * @return
     */
    @PutMapping("/{id}")
    public VehicleDTO updateVehicle(@PathVariable Long id,
                                    @RequestBody VehicleDTO vehicleDTO){
        VehicleDTO vehicleDTOToUpdate = vehicleAppService.updateVehicle(id, vehicleDTO);
        return vehicleDTOToUpdate;
    }

    /**
     * delete vehicle by id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id){
        vehicleAppService.deleteVehicle(id);
    }

}