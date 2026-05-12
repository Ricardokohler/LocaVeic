package dev.locaveics.repositories;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
