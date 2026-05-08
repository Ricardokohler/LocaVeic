package dev.locaveics.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_consultants")
public class Consultant extends Person{

    @OneToMany(mappedBy = "consultant")
    private List<Order> orderList;

    public Consultant() {
    }

    public Consultant(long id, String name, String phone, String cpf, String email, String address) {
        super(id, name, phone, cpf, email, address);
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
