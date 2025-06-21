package com.locaveics.locaveics.controllers;

import com.locaveics.locaveics.entities.RentalAgent;
import com.locaveics.locaveics.services.RentalAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental-agents")
public class RentalAgentController {


    @Autowired
    private RentalAgentService service;



    @PostMapping("/add")
    public ResponseEntity <?> create(@RequestBody(required = false) RentalAgent rentalAgent){

        if(rentalAgent==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo do RentalAgente vazio");
        }

        RentalAgent createdRentalAgent = service.create(rentalAgent);
        return new ResponseEntity<>(createdRentalAgent, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<RentalAgent>> getAll(){
        List <RentalAgent> allRentalAgents = service.getAll();

        return new ResponseEntity<>(allRentalAgents, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id) {
        Optional<RentalAgent> optionalRentalAgent = service.getById(id);

        if(optionalRentalAgent.isPresent()){
            return new ResponseEntity<>(optionalRentalAgent, HttpStatus.OK);

        } else  {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <RentalAgent> deletedRentalAgent = service.getById(id);

       if (deletedRentalAgent.isPresent()){
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("RentalAgente id:" + id +" deletado com sucesos");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " + id + "  não encontrado");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity <?> update(@RequestBody(required = false) RentalAgent rentalAgent, @PathVariable Long id){

        if (rentalAgent == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo da atualização vazio");
        }

        try {
            RentalAgent updatedRentalAgent = service.update(rentalAgent, id);
            return new ResponseEntity<>(updatedRentalAgent, HttpStatus.OK);

        }  catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id não encontrado");
        }
    }

}
