package dev.locaveics.services;

import dev.locaveics.entities.Client;
import dev.locaveics.entities.dtos.ClientDto;
import dev.locaveics.entities.mappers.ClientMapper;
import dev.locaveics.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository repository;


    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }


    //create
    public ClientDto create(ClientDto clientDto){
        Client createdClient = ClientMapper.map(clientDto);

        createdClient = repository.save(createdClient);
        return ClientMapper.map(createdClient);

    }


    //getAll
    public List<ClientDto> getAll(){
        List <Client> clientList = repository.findAll();
        return clientList.stream()
                .map(ClientMapper::map)
                .collect(Collectors.toList());
    }


    //getById
    public ClientDto getById(Long id){
        Optional<Client> optionalClient = repository.findById(id);

        return optionalClient.map(ClientMapper::map).orElse(null);
    }

    //getByFullName
    public ClientDto getByFullName(String name){
        Optional<Client> optionalClient = repository.findByName(name);

        return optionalClient.map(ClientMapper::map).orElse(null);
    }

    //getByCpf
    public ClientDto getByCpf(String cpf){
        Optional<Client> optionalClient = repository.findByCpf(cpf);

        return optionalClient.map(ClientMapper::map).orElse(null);
    }

    //getByEmail
    public ClientDto getByEmail(String email){
        Optional<Client> optionalClient = repository.findByEmail(email);

        return optionalClient.map(ClientMapper::map).orElse(null);
    }

    //updateById
    public ClientDto updateById(Long id, ClientDto clientDto) throws IOException {
        Optional<Client> oldClient = repository.findById(id);

        if(oldClient.isPresent()){
            Client newClient = ClientMapper.map(clientDto);
            newClient.setId(id);
            repository.save(newClient);
            return ClientMapper.map(newClient);

        } else throw new IOException("Id not found");
    }

    //deleteById
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
