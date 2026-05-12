package dev.locaveics.controllers;

import dev.locaveics.services.VehicleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service){
        this.service= service;
    }

    //create

    //getAll

    //getById

    //updateById

    //delete

}
