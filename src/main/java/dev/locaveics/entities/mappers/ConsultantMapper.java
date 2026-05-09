package dev.locaveics.entities.mappers;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.dtos.ConsultantDto;
import org.springframework.stereotype.Component;

@Component
public class ConsultantMapper {

    public static Consultant map(ConsultantDto dto){
        Consultant consultant = new Consultant();

        dto.setId(consultant.getId());
        dto.setName(consultant.getName());
        dto.setPhone(consultant.getPhone());
        dto.setCpf(consultant.getCpf());
        dto.setEmail(consultant.getEmail());
        dto.setAddress(consultant.getAddress());

        dto.setOrderList(consultant.getOrderList());

        return consultant;
    }

    public static ConsultantDto map(Consultant consultant){
        ConsultantDto dto = new ConsultantDto();

        consultant.setId(dto.getId());
        consultant.setName(dto.getName());
        consultant.setPhone(dto.getPhone());
        consultant.setCpf(dto.getCpf());
        consultant.setEmail(dto.getEmail());
        consultant.setAddress(dto.getAddress());

        return dto;

    }

}
