package dev.locaveics.entities.mappers;

import dev.locaveics.entities.Order;
import dev.locaveics.entities.dtos.OrderDto;

public class OrderMapper {


    public static OrderDto map(Order order){

        OrderDto dto = new OrderDto();

        if(dto.getId() != null){
            dto.setId(order.getId());
        }

        dto.setStartTime(order.getStartTime());
        dto.setFinalTime(order.getFinalTime());
        dto.setDiscount(order.getDiscount());
        dto.setFinalAmount(order.getFinalAmount());

        dto.setClient(order.getClient());
        dto.setConsultant(order.getConsultant());
        dto.setManager(order.getManager());
        dto.setVehicle(order.getVehicle());

        return dto;
    }

    public static Order map(OrderDto dto){
        Order order = new Order();

        order.setId(dto.getId());
        order.setStartTime(dto.getStartTime());
        order.setFinalTime(dto.getFinalTime());
        order.setDiscount(dto.getDiscount());
        order.setFinalAmount(dto.getFinalAmount());

        order.setClient(dto.getClient());
        order.setConsultant(dto.getConsultant());
        order.setManager(dto.getManager());
        order.setVehicle(dto.getVehicle());

        return order;
    }
}
