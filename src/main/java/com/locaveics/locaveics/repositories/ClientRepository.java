package com.locaveics.locaveics.repositories;

import com.locaveics.locaveics.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
