package dev.locaveics.repositories;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public Optional<Order> findByName(String name);

    public Optional<Order> findByCpf(String cpf);

    public Optional<Order> findByEmail(String email);

}
