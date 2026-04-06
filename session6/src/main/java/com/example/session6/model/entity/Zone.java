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
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Zone_name")
    private String name;

    private Long capacity;

    @Column(name = "occupied_spots")
    private Long occupiedSpots;

    @OneToMany(mappedBy = "zone")
    List<ParkingTicket> parkingTickets;
}
