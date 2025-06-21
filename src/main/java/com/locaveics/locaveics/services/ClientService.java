package com.locaveics.locaveics.services;

import com.locaveics.locaveics.entities.Client;
import com.locaveics.locaveics.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    //Create
    public Client create(Client client){
        return repository.save(client);
    }

    //GetAll
    public List <Client> getAll(){
        return repository.findAll();
    }

    //GetById
    public Optional <Client> getById(Long id) {
        return repository.findById(id);

    }

    //Delete
    public void delete(Long id){
        repository.deleteById(id);
    }

    //Update
    public Client update(Client client, Long id){
        Optional<Client> oldClient = repository.findById(id);

        if (oldClient.isPresent()) {
            Client newClient = oldClient.get();

            newClient.setName(client.getName());
            newClient.setAddress(client.getAddress());
            newClient.setPhone(client.getPhone());
            return repository.save(newClient);
        }

         else throw new RuntimeException("Id não encontrado") ; }


}
