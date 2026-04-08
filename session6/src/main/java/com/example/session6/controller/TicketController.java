package com.example.session6.controller;

import com.example.session6.model.dto.requestDto.TicketRequest;
import com.example.session6.model.dto.responseDto.TicketResponse;
import com.example.session6.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final ParkingService parkingService;

    @PostMapping("/create_ticket")
    public ResponseEntity<?> createTicket(@RequestBody TicketRequest req) {
        TicketResponse res = parkingService.checkIn(req);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
