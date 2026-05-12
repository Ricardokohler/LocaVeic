package dev.locaveics.entities.dtos;

import dev.locaveics.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;

    private Instant startTime;
    private LocalDateTime finalTime;

    private Double discount;
    private Double finalAmount;

    private Client client;
    private Consultant consultant;
    private Manager manager;
    private Vehicle vehicle;

}
