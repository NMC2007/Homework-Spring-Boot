package com.example.session15.service;

import com.example.session15.model.dto.request.OrderCreateDTO;
import com.example.session15.model.entity.Order;
import com.example.session15.model.entity.OrderStatus;

import java.util.List;

public interface OrderService {

    Order create(OrderCreateDTO req, String email);

    List<Order> myOrders(String email);

    List<Order> findAll();

    Order updateStatus(Long id, OrderStatus status);
}