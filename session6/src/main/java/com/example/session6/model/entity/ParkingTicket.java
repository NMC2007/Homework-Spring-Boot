package com.example.session6.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "parking_ticket")
public class ParkingTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in_time")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime checkInTime;
    @Column(name = "check_out_time")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime checkOutTime;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;
}
