package com.grabrental.cs544.vehicle.appservice;

import com.grabRental.cs544.dto.VehicleDTO;
import com.grabRental.cs544.model.Schedule;
import com.grabRental.cs544.model.Vehicle;
import com.grabrental.cs544.vehicle.domainservice.VehicleDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehicleAppService implements IVehicleAppService{

    @Autowired
    private VehicleDomainService vehicleDomainService;

    @Autowired
    private VehicleConverter vehicleConverter;

    /**
     * Getting the all the vehicle and convert to DTO
     * @return List<Vehicle>
     */
    @Override
    public List<VehicleDTO> getVehicles() {
        List<VehicleDTO> vehicleDTOList = vehicleDomainService.getVehicles()
                .stream()
                .map(vehicle -> vehicleConverter.toDTO(vehicle))
                .collect(Collectors.toList());
        return vehicleDTOList;

    }

    /**
     * Find vehicle by Id and convert to DTO
     * @param id
     * @return VehicleDto
     */
    @Override
    public VehicleDTO getVehicleById(Long id) {
        return vehicleConverter.toDTO(vehicleDomainService.getVehicleById(id));
    }

    /**
     * save vehicle into database
     * @param vehicleDTO
     * @return vehicleDto
     */
    @Override
    public VehicleDTO createVehicleDTO(VehicleDTO vehicleDTO) {
        Vehicle vehicleToSave = vehicleConverter.toDAO(vehicleDTO);
        vehicleToSave =  vehicleDomainService.createVehicle(vehicleToSave);
        return vehicleConverter.toDTO(vehicleToSave);
    }

    /**
     * convert dto to dao and update the vehicle
     * @param id
     * @param vehicleDTO
     * @return vehicledto
     */
    @Override
    public VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDTO) {
        Vehicle vehicleToUpdate = vehicleConverter.toDAO(vehicleDTO);
        vehicleToUpdate = vehicleDomainService.updateVehicle(id, vehicleToUpdate);
        return vehicleConverter.toDTO(vehicleToUpdate);
    }

    /**
     * remove the vehicle based on id
     * @param id
     */
    @Override
    public void deleteVehicle(Long id) {
        vehicleDomainService.deleteVehicle(id);
    }
}
