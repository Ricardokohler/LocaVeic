package com.locaveics.locaveics.controllers;

import com.locaveics.locaveics.entities.Order;
import com.locaveics.locaveics.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderService service;



    @PostMapping("/add")
    public ResponseEntity <?> create(@RequestBody(required = false) Order Order){

        if(Order==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo do Ordere vazio");
        }

        Order createdOrder = service.create(Order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<Order>> getAll(){
        List <Order> allOrders = service.getAll();

        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id) {
        Optional<Order> optionalOrder = service.getById(id);

        if(optionalOrder.isPresent()){
            return new ResponseEntity<>(optionalOrder, HttpStatus.OK);

        } else  {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <Order> deletedOrder = service.getById(id);

       if (deletedOrder.isPresent()){
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ordere id:" + id +" deletado com sucesos");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " + id + "  não encontrado");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity <?> update(@RequestBody(required = false) Order Order, @PathVariable Long id){

        if (Order == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo da atualização vazio");
        }

        try {
            Order updatedOrder = service.update(Order, id);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);

        }  catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id não encontrado");
        }
    }

}
