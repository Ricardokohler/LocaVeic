package com.locaveics.locaveics.controllers;

import com.locaveics.locaveics.entities.Client;
import com.locaveics.locaveics.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    private ClientService service;



    @PostMapping("/add")
    public ResponseEntity <?> create(@RequestBody(required = false) Client client){

        if(client==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo do cliente vazio");
        }

        Client createdClient = service.create(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<Client>> getAll(){
        List <Client> allClients = service.getAll();

        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id) {
        Optional<Client> optionalClient = service.getById(id);

        if(optionalClient.isPresent()){
            return new ResponseEntity<>(optionalClient, HttpStatus.OK);

        } else  {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <Client> deletedClient = service.getById(id);

       if (deletedClient.isPresent()){
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente id:" + id +" deletado com sucesos");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " + id + "  não encontrado");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity <?> update(@RequestBody(required = false) Client client, @PathVariable Long id){

        if (client == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo da atualização vazio");
        }

        try {
            Client updatedClient = service.update(client, id);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);

        }  catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id não encontrado");
        }
    }

}
