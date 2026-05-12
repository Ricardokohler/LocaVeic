package dev.locaveics.repositories;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
