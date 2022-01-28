package com.grabrental.cs544.driver.controller;

import com.grabRental.cs544.dto.DriverDTO;
import com.grabrental.cs544.driver.appservice.IDriverAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/drivers")
public class DriverController {

    @Autowired
    IDriverAppService driverAppService;

    @PostMapping
    public DriverDTO save(@RequestBody DriverDTO driverDTO){
        return driverAppService.save(driverDTO);
    }

    @GetMapping(value="/{id}")
    public DriverDTO get(@PathVariable long id){
        return driverAppService.get(id);
    }

    @GetMapping
    public List<DriverDTO> get(){
        return driverAppService.getAll();
    }

    @PutMapping(value="/{id}")
    public DriverDTO put(@RequestBody DriverDTO driverDTO, @PathVariable long id){
        return driverAppService.update(driverDTO, id);
    }

    @DeleteMapping(value="/{id}")
    public Long delete(@PathVariable long id){
        return driverAppService.delete(id);
    }


}
