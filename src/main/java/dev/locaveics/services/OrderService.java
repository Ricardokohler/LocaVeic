package dev.locaveics.services;

import dev.locaveics.entities.Order;
import dev.locaveics.entities.dtos.OrderDto;
import dev.locaveics.entities.mappers.ManagerMapper;
import dev.locaveics.entities.mappers.OrderMapper;
import dev.locaveics.repositories.OrderRepository;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository){
        this.repository= repository;
    }

    //create
    public OrderDto createOrder(OrderDto orderDto){
        Order createdOrder = OrderMapper.map(orderDto);

        repository.save(createdOrder);
        return OrderMapper.map(createdOrder);
    }

    //getAll
    public List<OrderDto> getAll(){
        List<Order> orderList = repository.findAll();

        return orderList.stream()
                .map(OrderMapper::map)
                .collect(Collectors.toList());
    }

    //getById
    public OrderDto getById(Long id){
        Optional<Order> optionalOrder = repository.findById(id);

        return optionalOrder.map(OrderMapper::map).orElse(null);
    }

    //updateById
    public OrderDto updateById(Long id, OrderDto orderDto){
        Optional<Order> oldOrder = repository.findById(id);

        if(oldOrder.isPresent()){

            Order newOrder = OrderMapper.map(orderDto);

            newOrder.setId(id);
            return OrderMapper.map(newOrder);
        } else throw new RuntimeException("Id not found");
    }

    //deleteById
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
