package dev.locaveics.controllers;

import dev.locaveics.entities.dtos.ClientDto;
import dev.locaveics.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody ClientDto clientDto) {
        ClientDto createdClient = service.create(clientDto);

    return ResponseEntity.status(HttpStatus.CREATED).body("Client successfully created: " + createdClient);
    }

    //getAll
    @GetMapping("get/all")
    public ResponseEntity<List<ClientDto>> getAll() {
        List<ClientDto> clientList = service.getAll();

        return ResponseEntity.ok(clientList);
    }

    //getById
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        ClientDto clientDto = service.getById(id);
        if(clientDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(clientDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found: " + id);
        }
    }

    //getByFullName
    @GetMapping("/getByFullName/{name}")
    public ResponseEntity<?> getByFullName(@PathVariable String name) {

        ClientDto clientDto = service.getByFullName(name);
        if(clientDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(clientDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Name not found: " + name);
        }
    }

    //getByCpf
    @GetMapping("/getByCpf/{cpf}")
    public ResponseEntity<?> getByCpf(@PathVariable String cpf) {

        ClientDto clientDto = service.getByCpf(cpf);
        if(clientDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(clientDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf not found: " + cpf);
        }
    }

    //getByEmail
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        ClientDto clientDto = service.getByEmail(email);
        if(clientDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(clientDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found: " + email);
        }
    }

    //updateById
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ClientDto client) throws IOException {
        ClientDto clientDto = service.updateById(id, client);

        if(clientDto != null){
            return ResponseEntity.status(HttpStatus.OK).body("Client successfully " + client);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //deleteById
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        ClientDto clientDto = service.getById(id);

        if(clientDto != null){
            service.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body("Client Successfully deleted: Id " + clientDto.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found: " + id);
        }
    }
}
