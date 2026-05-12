package dev.locaveics.services;

import dev.locaveics.entities.Vehicle;
import dev.locaveics.entities.dtos.VehicleDto;
import dev.locaveics.entities.mappers.VehicleMapper;
import dev.locaveics.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository){
        this.repository= repository;
    }

    //create
    public VehicleDto create(VehicleDto vehicleDto){
        Vehicle vehicle = VehicleMapper.map(vehicleDto);
        Vehicle createdVehicle = repository.save(vehicle);

        return VehicleMapper.map(createdVehicle);
    }

    //getAll
    public List<VehicleDto> getAll(){
        List<Vehicle> vehicleList = repository.findAll();

        return vehicleList.stream()
                .map(VehicleMapper::map)
                .collect(Collectors.toList());
    }

    //getById
    public VehicleDto getById(Long id){

        Optional<Vehicle> optionalVehicle = repository.findById(id);

        return optionalVehicle.map(VehicleMapper::map).orElse(null);
    }

    //updateById
    public VehicleDto updateById(Long id, VehicleDto vehicleDto){
        Optional<Vehicle> oldVehicle = repository.findById(id);

        if(oldVehicle.isPresent()){

            Vehicle newVehicle = VehicleMapper.map(vehicleDto);
            newVehicle.setId(id);
            repository.save(newVehicle);

            return VehicleMapper.map(newVehicle);
        } else throw new RuntimeException("Id not found");
    }

    //deleteById
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
