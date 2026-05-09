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
@RequestMapping("/consultant")
public class ConsultantController {

    private final ConsultantService service;

    public ConsultantController(ConsultantService service) {
        this.service = service;
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<ConsultantDto> create(@RequestBody ConsultantDto consultantDto) {
        ConsultantDto createdConsultant = service.create(consultantDto);

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

        ConsultantDto consultantDto = service.getById(id);
        return new ResponseEntity<>(consultantDto, HttpStatus.OK);

    }

    //getByFullName
    @GetMapping("/{name}")
    public ResponseEntity<?> getByFullName(@PathVariable String name) {
        ConsultantDto consultantDto = service.getByFullName(name);
        return new ResponseEntity<>(consultantDto, HttpStatus.OK);

    }

    //getByCpf
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getByCpf(@PathVariable String cpf) {
        ConsultantDto consultantDto = service.getByCpf(cpf);
        return new ResponseEntity<>(consultantDto, HttpStatus.OK);

    }

    //getByEmail
    @GetMapping("/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        ConsultantDto consultantDto = service.getByEmail(email);
        return new ResponseEntity<>(consultantDto, HttpStatus.OK);

    }

    //updateById
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ConsultantDto consultant) throws IOException {
        ConsultantDto consultantDto = service.updateById(id, consultant);

        return new ResponseEntity<>(consultantDto, HttpStatus.OK);

    }

    //deleteById
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        ConsultantDto consultantDto = service.getById(id);

        if(consultantDto != null){
            service.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body("Consultant Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }
}
