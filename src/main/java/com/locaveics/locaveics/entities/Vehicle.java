package com.locaveics.locaveics.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String brand;
    private double pricePerHour;

    public Vehicle(Long id, String model, String brand, double pricePerHour) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.pricePerHour = pricePerHour;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "vehicle")
    private Order order;
}
