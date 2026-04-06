package com.example.session6.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate")
    private String licensePlate;
    private String color;
    @Enumerated(EnumType.STRING)
    private VehicleEnum type;

    @OneToMany(mappedBy = "vehicle")
    List<ParkingTicket> parkingTickets;
}
