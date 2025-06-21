package com.locaveics.locaveics.services;

import com.locaveics.locaveics.entities.Order;
import com.locaveics.locaveics.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    //Create
    public Order create(Order Order){
        return repository.save(Order);
    }

    //GetAll
    public List <Order> getAll(){
        return repository.findAll();
    }

    //GetById
    public Optional <Order> getById(Long id) {
        return repository.findById(id);

    }

    //Delete
    public void delete(Long id){
        repository.deleteById(id);
    }

    //Update
    public Order update(Order Order, Long id){
        Optional<Order> oldOrder = repository.findById(id);

        if (oldOrder.isPresent()) {
            Order newOrder = oldOrder.get();

            newOrder.setOrderMoment(Order.getOrderMoment());
            newOrder.setClient(Order.getClient());
            newOrder.setVehicle(Order.getVehicle());
            newOrder.setRentalAgent(Order.getRentalAgent());
            return repository.save(newOrder);
        }

         else throw new RuntimeException("Id não encontrado") ; }


}
