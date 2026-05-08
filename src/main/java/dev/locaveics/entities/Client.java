package dev.locaveics.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_clients")
public class Client extends Person{

    public Client() {
    }

    @OneToMany(mappedBy = "client")
    private List<Order> orderList;

    public Client(long id, String name, String phone, String cpf, String email, String address) {
        super(id, name, phone, cpf, email, address);
    }

    public List<Order> getOrderList(){
        return orderList;
    }


}
