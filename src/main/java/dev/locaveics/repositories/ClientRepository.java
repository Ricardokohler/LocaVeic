package dev.locaveics.repositories;

import dev.locaveics.entities.Client;
import dev.locaveics.entities.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public Optional<Client> findByName(String name);

    public Optional<Client> findByCpf(String cpf);

    public Optional<Client> findByEmail(String email);

}
