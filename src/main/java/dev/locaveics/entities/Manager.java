package dev.locaveics.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_managers")
public class Manager extends Person{

    @OneToMany(mappedBy = "manager")
    private List<Order> orderList;

    public Manager() {
    }

    public Manager(long id, String name, String phone, String cpf, String email, String address) {
        super(id, name, phone, cpf, email, address);
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
