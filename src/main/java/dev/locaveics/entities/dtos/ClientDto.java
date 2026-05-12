package dev.locaveics.entities.dtos;

import dev.locaveics.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id;
    private String name;
    private String phone;
    private String cpf;
    private String email;
    private String address;

    private List<Order> orderList;

}
