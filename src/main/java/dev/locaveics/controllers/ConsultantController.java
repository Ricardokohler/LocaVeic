package dev.locaveics.controllers;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.dtos.ConsultantDto;
import dev.locaveics.entities.mappers.ConsultantMapper;
import dev.locaveics.services.ConsultantService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/consultants")
public class ConsultantController {

    private final ConsultantService service;

    public ConsultantController(ConsultantService service) {
        this.service = service;
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody ConsultantDto consultantDto) {
        ConsultantDto createdConsultant = service.create(consultantDto);

    return ResponseEntity.status(HttpStatus.CREATED).body("Consultant successfully created: " + createdConsultant);
    }

    //getAll
    @GetMapping("get/all")
    public ResponseEntity<List<ConsultantDto>> getAll() {
        List<ConsultantDto> consultantList = service.getAll();

        return ResponseEntity.ok(consultantList);
    }

    //getById
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        ConsultantDto consultantDto = service.getById(id);
        if(consultantDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(consultantDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found: " + id);
        }
    }

    //getByFullName
    @GetMapping("/getByFullName/{name}")
    public ResponseEntity<?> getByFullName(@PathVariable String name) {

        ConsultantDto consultantDto = service.getByFullName(name);
        if(consultantDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(consultantDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Name not found: " + name);
        }
    }

    //getByCpf
    @GetMapping("/getByCpf/{cpf}")
    public ResponseEntity<?> getByCpf(@PathVariable String cpf) {

        ConsultantDto consultantDto = service.getByCpf(cpf);
        if(consultantDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(consultantDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf not found: " + cpf);
        }
    }

    //getByEmail
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        ConsultantDto consultantDto = service.getByEmail(email);
        if(consultantDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(consultantDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found: " + email);
        }
    }

    //updateById
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ConsultantDto consultant) throws IOException {
        ConsultantDto consultantDto = service.updateById(id, consultant);

        if(consultantDto != null){
            return ResponseEntity.status(HttpStatus.OK).body("Consultant successfully " + consultant);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //deleteById
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        ConsultantDto deletedClient = service.getById(id);

        if(deletedClient != null){
            service.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body("Consultant Successfully deleted: Id " + deletedClient.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found: " + id);
        }
    }
}
