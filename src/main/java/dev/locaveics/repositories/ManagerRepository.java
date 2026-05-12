package dev.locaveics.repositories;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    public Optional<Manager> findByName(String name);

    public Optional<Manager> findByCpf(String cpf);

    public Optional<Manager> findByEmail(String email);

}
