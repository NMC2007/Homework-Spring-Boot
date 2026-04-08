package com.example.session6.service;

import com.example.session6.model.dto.requestDto.TicketRequest;
import com.example.session6.model.dto.responseDto.TicketResponse;
import com.example.session6.model.entity.ParkingTicket;
import com.example.session6.model.entity.Vehicle;
import com.example.session6.model.entity.Zone;
import com.example.session6.repository.TicketRepository;
import com.example.session6.repository.VehicleRepository;
import com.example.session6.repository.ZoneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ParkingService {
    private final VehicleRepository vehicleRepository;
    private final ZoneRepository zoneRepository;
    private final TicketRepository ticketRepository;


    @Transactional
    public TicketResponse checkIn(TicketRequest req) {
        Vehicle vehicle = vehicleRepository.findById(req.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy id phương tiện"));
        Zone zone = zoneRepository.findById(req.getZoneId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy id chỗ đỗ"));

        if (zone.getCapacity() <= 0) {
            throw new RuntimeException("Hết chỗ đỗ");
        }

        zone.setCapacity(zone.getCapacity() - 1);
        zone.setOccupiedSpots(zone.getOccupiedSpots() + 1);

        ParkingTicket newParkingTicket = new ParkingTicket();
        newParkingTicket.setCheckInTime(LocalDateTime.now()); // thời gian hiện tại
        newParkingTicket.setCheckOutTime(null);
        newParkingTicket.setVehicle(vehicle);
        newParkingTicket.setZone(zone);

        ParkingTicket ticket = ticketRepository.save(newParkingTicket);

        TicketResponse res = new TicketResponse();
        res.setId(ticket.getId());
        res.setCheckInTime(ticket.getCheckInTime());
        res.setCheckOutTime(ticket.getCheckOutTime());
        res.setLicensePlate(vehicle.getLicensePlate());
        res.setZoneName(zone.getName());

        return res;
    }
}
