package dev.locaveics.controllers;

import dev.locaveics.entities.Order;
import dev.locaveics.entities.dtos.OrderDto;
import dev.locaveics.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service){
        this.service= service;
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody OrderDto orderDto){
        OrderDto createdOrder = service.createOrder(orderDto);

        return ResponseEntity.ok("Order successfully created" + createdOrder);
    }

    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDto>> getAll(){
        List<OrderDto> orderDtoList = service.getAll();

        return ResponseEntity.ok(orderDtoList);
    }

    //getById
    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        OrderDto orderDto = service.getById(id);

        if(orderDto != null){
            return ResponseEntity.ok("Order found: " + orderDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    //updateById
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody OrderDto orderDto){
        OrderDto updatedOrder = service.updateById(id, orderDto);

        if (updatedOrder != null){
            return ResponseEntity.ok("Order Updated successfully: " + updatedOrder);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found.");
        }
    }

    //deleteById
    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        OrderDto deletedOrder = service.getById(id);

        if(deletedOrder != null){
            service.deleteById(id);
            return ResponseEntity.ok("Order successfully deleted. Id: " + deletedOrder.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

}
