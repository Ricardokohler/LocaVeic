package dev.locaveics.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String model;
    private String brand;
    //CHASSI
    //VALUEPERHOUR


    @OneToMany(mappedBy = "vehicle")
    private List<Order> orderList;

    public Vehicle() {
    }

    public Vehicle(long id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
