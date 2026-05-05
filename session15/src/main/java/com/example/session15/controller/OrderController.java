package com.example.session15.controller;

import com.example.session15.model.dto.request.OrderCreateDTO;
import com.example.session15.model.dto.request.OrderStatusUpdateDTO;
import com.example.session15.security.userdetail.CustomUserDetails;
import com.example.session15.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // CUSTOMER
    @PostMapping
    public Object create(
            @Valid @RequestBody OrderCreateDTO req,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        return orderService.create(req, userDetails.getUsername());
    }

    // CUSTOMER
    @GetMapping("/my")
    public Object myOrders(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        return orderService.myOrders(userDetails.getUsername());
    }

    // STAFF + ADMIN
    @GetMapping
    public Object findAll() {
        return orderService.findAll();
    }

    // STAFF
    @PutMapping("/{id}/status")
    public Object updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody OrderStatusUpdateDTO req
    ) {
        return orderService.updateStatus(id, req.getStatus());
    }
}
