package com.locaveics.locaveics.controllers;

import com.locaveics.locaveics.entities.Vehicle;
import com.locaveics.locaveics.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {


    @Autowired
    private VehicleService service;



    @PostMapping("/add")
    public ResponseEntity <?> create(@RequestBody(required = false) Vehicle vehicle){

        if(vehicle==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo do Vehiclee vazio");
        }

        Vehicle createdVehicle = service.create(vehicle);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<Vehicle>> getAll(){
        List <Vehicle> allVehicles = service.getAll();

        return new ResponseEntity<>(allVehicles, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id) {
        Optional<Vehicle> optionalVehicle = service.getById(id);

        if(optionalVehicle.isPresent()){
            return new ResponseEntity<>(optionalVehicle, HttpStatus.OK);

        } else  {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <Vehicle> deletedVehicle = service.getById(id);

       if (deletedVehicle.isPresent()){
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Vehiclee id:" + id +" deletado com sucesos");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " + id + "  não encontrado");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity <?> update(@RequestBody(required = false) Vehicle vehicle, @PathVariable Long id){

        if (vehicle == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo da atualização vazio");
        }

        try {
            Vehicle updatedVehicle = service.update(vehicle, id);
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);

        }  catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id não encontrado");
        }
    }

}
