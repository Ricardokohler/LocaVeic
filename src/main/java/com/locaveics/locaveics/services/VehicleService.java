package com.locaveics.locaveics.services;

import com.locaveics.locaveics.entities.Vehicle;
import com.locaveics.locaveics.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    //Create
    public Vehicle create(Vehicle Vehicle){
        return repository.save(Vehicle);
    }

    //GetAll
    public List <Vehicle> getAll(){
        return repository.findAll();
    }

    //GetById
    public Optional <Vehicle> getById(Long id) {
        return repository.findById(id);

    }

    //Delete
    public void delete(Long id){
        repository.deleteById(id);
    }

    //Update
    public Vehicle update(Vehicle vehicle, Long id){
        Optional<Vehicle> oldVehicle = repository.findById(id);

        if (oldVehicle.isPresent()) {
            Vehicle newVehicle = oldVehicle.get();

            newVehicle.setModel(vehicle.getModel());
            newVehicle.setBrand(vehicle.getBrand());
            newVehicle.setPricePerHour(vehicle.getPricePerHour());
            return repository.save(newVehicle);
        }

         else throw new RuntimeException("Id não encontrado") ; }


}
