package dev.locaveics.repositories;

import dev.locaveics.entities.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    public Optional<Consultant> findByName(String name);

    public Optional<Consultant> findByCpf(String cpf);

    public Optional<Consultant> findByEmail(String email);

}
