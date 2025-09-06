package com.locaveics.locaveics.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_rental_agents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private LocalDate contractDate;

    public RentalAgent(Long id, String name, String address, String phone, LocalDate contractDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contractDate = contractDate;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "rentalAgent")
    private List <Order> order = new ArrayList<>();
}
