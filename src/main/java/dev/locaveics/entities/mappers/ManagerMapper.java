package dev.locaveics.entities.mappers;

import dev.locaveics.entities.Manager;
import dev.locaveics.entities.dtos.ManagerDto;

public class ManagerMapper {

    public static ManagerDto map(Manager manager){
        ManagerDto dto = new ManagerDto();


        dto.setId(manager.getId());
        dto.setName(manager.getName());
        dto.setPhone(manager.getPhone());
        dto.setCpf(manager.getCpf());
        dto.setEmail(manager.getEmail());
        dto.setAddress(manager.getAddress());

        return dto;
    }

    public static Manager map(ManagerDto dto){
        Manager manager = new Manager();

        if(dto.getId() != null){
            manager.setId(dto.getId());
        }

        manager.setId(dto.getId());
        manager.setName(dto.getName());
        manager.setPhone(dto.getPhone());
        manager.setEmail(dto.getEmail());
        manager.setAddress(dto.getAddress());

        return manager;
    }
}
