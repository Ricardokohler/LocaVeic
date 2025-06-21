package com.locaveics.locaveics;

import com.locaveics.locaveics.entities.Client;
import com.locaveics.locaveics.entities.Order;
import com.locaveics.locaveics.entities.RentalAgent;
import com.locaveics.locaveics.entities.Vehicle;
import com.locaveics.locaveics.repositories.ClientRepository;
import com.locaveics.locaveics.repositories.OrderRepository;
import com.locaveics.locaveics.repositories.RentalAgentRepository;
import com.locaveics.locaveics.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RentalAgentRepository rentalAgentRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OrderRepository orderRepository;



    @Override
    public void run(String... args) throws Exception {

        Client c1 = new Client(null, "Rodrigo Souza Lima", "Rua das Palmeiras, 482", "(11) 98765-4321");
        Client c2 = new Client(null, "Ana Beatriz Machado", "Avenida Brasil, 1234", "(21) 99876-5432");
        Client c3 = new Client(null, "Carlos Eduardo Santos", "Travessa das Laranjeiras, 78", "(31) 91234-5678");
        Client c4 = new Client(null, "Mariana Ferreira Costa", "Rua das Acácias, 256", "(41) 98712-3456");
        Client c5 = new Client(null, "Lucas Almeida Ribeiro", "Praça dos Girassóis, 19", "(51) 99988-7766");
        Client c6 = new Client(null, "Fernanda Lopes Silva", "Rua do Sol, 350", "(61) 97654-3210");
        clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

        Vehicle v1 = new Vehicle(null, "Fiat Argo","Fiat", 45.0);
        Vehicle v2 = new Vehicle(null, "Chrysler", "Chevrollet de boy", 59.0);
        Vehicle v3 = new Vehicle(null, "Uno com escada", "Fiat né papai", 558.0);
        Vehicle v4 = new Vehicle(null, "Monza carburadão", "Nem sei n manjo de carro", 45.6);
        Vehicle v5 = new Vehicle(null, "Stilo", "Fiat", 48.6);
        vehicleRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5));

        RentalAgent ra1 = new RentalAgent(null, "Kléber Luis Fonseca", "Avenida Paulista, 900", "(11) 4038-2816", LocalDate.of(2003, 8, 17));
        RentalAgent ra2 = new RentalAgent(null, "Mariana Alves Pereira", "Rua das Laranjeiras, 350", "(21) 99876-4321", LocalDate.of(1995, 3, 22));
        RentalAgent ra3 = new RentalAgent(null, "Carlos Eduardo Gomes", "Praça da Sé, 120", "(31) 91234-5678", LocalDate.of(1988, 12, 5));
        RentalAgent ra4 = new RentalAgent(null, "Fernanda Rodrigues Silva", "Travessa das Flores, 78", "(41) 98765-4320", LocalDate.of(2000, 6, 30));
        RentalAgent ra5 = new RentalAgent(null, "Lucas Martins Souza", "Avenida Brasil, 1500", "(51) 97654-3210", LocalDate.of(1992, 11, 11));
        rentalAgentRepository.saveAll(Arrays.asList(ra1, ra2, ra3, ra4, ra5));

        Order o1 = new Order(null, LocalDateTime.now(), c1, v1, ra1);
        Order o2 = new Order(null, LocalDateTime.of(2024, 11, 15, 14, 30), c2, v2, ra2);
        Order o3 = new Order(null, LocalDateTime.of(2026, 6, 30, 5, 6), c3, v3, ra3);
        Order o4 = new Order(null, LocalDateTime.of(2023, 5, 12, 4, 15), c5, v5, ra5);
        Order o5 = new Order(null, LocalDateTime.of(2024, 10, 10, 5, 8), c4, v4, ra4);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4,o5));




    }
}
