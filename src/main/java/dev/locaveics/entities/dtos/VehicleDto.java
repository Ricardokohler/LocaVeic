package dev.locaveics.entities.dtos;

import dev.locaveics.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    private Long id;
    private String Model;
    private String brand;

    private List<Order> orderList;

}
