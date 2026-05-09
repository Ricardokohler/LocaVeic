package dev.locaveics.controllers;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.dtos.ConsultantDto;
import dev.locaveics.services.ConsultantService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/consultant")
public class ConsultantController {

    private final ConsultantService service;

    public ConsultantController(ConsultantService service) {
        this.service = service;
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<ConsultantDto> create(@RequestBody ConsultantDto consultant) {
        ConsultantDto createdConsultant = service.create(consultant);

        return new ResponseEntity<>(createdConsultant, HttpStatus.CREATED);
    }

    //getAll
    @GetMapping("/all")
    public ResponseEntity<List<ConsultantDto>> getAll() {
        List<ConsultantDto> consultantList = service.getAll();

        return new ResponseEntity<>(consultantList, HttpStatus.OK);
    }

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Consultant> optionalConsultant = service.getById(id);

        if (optionalConsultant.isPresent()) {
            Consultant consultant = optionalConsultant.get();

            return new ResponseEntity<>(consultant, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //getByFullName
    @GetMapping("/{name}")
    public ResponseEntity<?> getByFullName(@PathVariable String name) {
        Optional<Consultant> optionalConsultant = service.getByFullName(name);

        if (optionalConsultant.isPresent()) {
            Consultant consultant = optionalConsultant.get();

            return new ResponseEntity<>(consultant, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //getByCpf
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getByCpf(@PathVariable String cpf) {
        Optional<Consultant> optionalConsultant = service.getByFullName(cpf);

        if (optionalConsultant.isPresent()) {
            Consultant consultant = optionalConsultant.get();

            return new ResponseEntity<>(consultant, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //getByEmail
    @GetMapping("/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        Optional<Consultant> optionalConsultant = service.getByFullName(email);

        if (optionalConsultant.isPresent()) {
            Consultant consultant = optionalConsultant.get();

            return new ResponseEntity<>(consultant, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //updateById
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Consultant consultant) throws IOException {
        Optional<Consultant> optionalConsultant = service.getById(id);

        if (optionalConsultant.isPresent()) {
            Consultant updatedConsultant = service.updateById(id, consultant);

            return new ResponseEntity<>(updatedConsultant, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //deleteById
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        Optional<Consultant> optionalConsultant = service.getById(id);

        if(optionalConsultant.isPresent()){
            service.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body("Consultant Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }
}
