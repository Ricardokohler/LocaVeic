package dev.locaveics.controllers;

import dev.locaveics.entities.dtos.VehicleDto;
import dev.locaveics.services.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody VehicleDto vehicleDto) {
        VehicleDto createdVehicle = service.create(vehicleDto);

    return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle successfully created: " + createdVehicle);
    }

    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<VehicleDto>> getAll() {
        List<VehicleDto> vehicleList = service.getAll();

        return ResponseEntity.ok(vehicleList);
    }

    //getById
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        VehicleDto vehicleDto = service.getById(id);
        if(vehicleDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(vehicleDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found: " + id);
        }
    }

    //updateById
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody VehicleDto vehicleDto) throws IOException {
        VehicleDto VehicleDto = service.updateById(id, vehicleDto);

        if(VehicleDto != null){
            return ResponseEntity.status(HttpStatus.OK).body("Vehicle successfully " + VehicleDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //deleteById
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        VehicleDto deletedVehicle = service.getById(id);

        if(deletedVehicle != null){
            service.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body("Vehicle Successfully deleted: Id " + deletedVehicle.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found: " + id);
        }
    }
}
