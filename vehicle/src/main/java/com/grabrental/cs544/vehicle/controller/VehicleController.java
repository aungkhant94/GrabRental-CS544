package com.grabrental.cs544.vehicle.controller;

import com.grabRental.cs544.dto.SearchDTO;
import com.grabRental.cs544.dto.VehicleDTO;
import com.grabrental.cs544.vehicle.appservice.IVehicleAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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
    public ResponseEntity<Object> createVehicle(@Valid @RequestBody VehicleDTO vehicleDTO){
         VehicleDTO vehicleDTOToSave = vehicleAppService.createVehicleDTO(vehicleDTO);
         return new ResponseEntity<>("Vehicle saved successfully", HttpStatus.OK);
    }

    /**
     * update vehicle of particular id
     * @param id
     * @param vehicleDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVehicle(@PathVariable Long id,
                                    @Valid @RequestBody VehicleDTO vehicleDTO){
        VehicleDTO vehicleDTOToUpdate = vehicleAppService.updateVehicle(id, vehicleDTO);
        return new ResponseEntity<>("Vehicle updated Successfully", HttpStatus.OK);
    }

    /**
     * delete vehicle by id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id){
        vehicleAppService.deleteVehicle(id);
    }


    /**
     * Retrieve all the vehicles available between a time frame
     * @param searchDTO
     * @return
     */
    @GetMapping("/availableVehicles")
    public List<VehicleDTO> getAvailableVehicles(@RequestBody SearchDTO searchDTO){
        return vehicleAppService.getAvailableVehicles(searchDTO.getStartDate(), searchDTO.getEndDate());

    }

}
