package dev.locaveics.entities.mappers;

import dev.locaveics.entities.Client;
import dev.locaveics.entities.dtos.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {


    public static Client map(ClientDto dto){

        Client client = new Client();

        if(dto.getId() != null){
            client.setId(dto.getId());
        }

        client.setName(dto.getName());
        client.setPhone(dto.getPhone());
        client.setCpf(dto.getCpf());
        client.setEmail(dto.getEmail());
        client.setAddress(dto.getAddress());

        return client;
    }

    public static ClientDto map(Client client){

        ClientDto dto = new ClientDto();

        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setPhone(client.getPhone());
        dto.setCpf(client.getCpf());
        dto.setEmail(client.getEmail());
        dto.setAddress(client.getAddress());

        return dto;
    }
}