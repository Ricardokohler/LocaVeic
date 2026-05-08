package dev.locaveics.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Instant startTime;
    private LocalDateTime finalTime;

    private Double discount;
    private Double finalAmount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Order(long id, Instant startTime, LocalDateTime finalTime, Double discount, Double finalAmount, Client client, Manager manager, Consultant consultant, Vehicle vehicle) {
        this.id = id;
        this.startTime = startTime;
        this.finalTime = finalTime;
        this.discount = discount;
        this.finalAmount = finalAmount;
        this.client = client;
        this.manager = manager;
        this.consultant = consultant;
        this.vehicle = vehicle;
    }

    public long getId() {
        return id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(LocalDateTime finalTime) {
        this.finalTime = finalTime;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
