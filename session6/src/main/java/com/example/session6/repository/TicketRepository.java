package com.example.session6.repository;

import com.example.session6.model.entity.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<ParkingTicket, Long> {
}
