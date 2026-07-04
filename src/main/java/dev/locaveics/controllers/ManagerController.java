package dev.locaveics.controllers;

import dev.locaveics.entities.dtos.ManagerDto;
import dev.locaveics.services.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/managers")
public class ManagerController {

    private final ManagerService service;

    public ManagerController(ManagerService service) {
        this.service = service;
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody ManagerDto managerDto) {
        ManagerDto createdManager = service.create(managerDto);

    return ResponseEntity.status(HttpStatus.CREATED).body("Manager successfully created: " + createdManager);
    }

    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<ManagerDto>> getAll() {
        List<ManagerDto> managerList = service.getAll();

        return ResponseEntity.ok(managerList);
    }

    //getById
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        ManagerDto managerDto = service.getById(id);
        if(managerDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(managerDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found: " + id);
        }
    }

    //getByFullName
    @GetMapping("/getByFullName/{name}")
    public ResponseEntity<?> getByFullName(@PathVariable String name) {

        ManagerDto managerDto = service.getByFullName(name);
        if(managerDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(managerDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Name not found: " + name);
        }
    }

    //getByCpf
    @GetMapping("/getByCpf/{cpf}")
    public ResponseEntity<?> getByCpf(@PathVariable String cpf) {

        ManagerDto managerDto = service.getByCpf(cpf);
        if(managerDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(managerDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf not found: " + cpf);
        }
    }

    //getByEmail
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        ManagerDto managerDto = service.getByEmail(email);
        if(managerDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(managerDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found: " + email);
        }
    }

    //updateById
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ManagerDto manager) throws IOException {
        ManagerDto updatedManager = service.updateById(id, manager);

        if(updatedManager != null){
            return ResponseEntity.status(HttpStatus.OK).body("Manager successfully " + updatedManager);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //deleteById
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        ManagerDto deletedManager = service.getById(id);

        if(deletedManager != null){
            service.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body("Manager Successfully deleted: Id " + deletedManager.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found: " + id);
        }
    }
}
