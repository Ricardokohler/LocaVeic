package dev.locaveics.entities.mappers;

import dev.locaveics.entities.Vehicle;
import dev.locaveics.entities.dtos.VehicleDto;

public class VehicleMapper {


    public static Vehicle map(VehicleDto dto){

        Vehicle vehicle = new Vehicle();

        if(dto.getId() != null) {
            vehicle.setId(dto.getId());
        }

        vehicle.setModel(dto.getModel());
        vehicle.setBrand(dto.getBrand());

        return vehicle;
    }

    public static VehicleDto map(Vehicle vehicle){

        VehicleDto dto = new VehicleDto();

        dto.setModel(vehicle.getModel());
        dto.setBrand(vehicle.getBrand());

        return dto;

    }

}
