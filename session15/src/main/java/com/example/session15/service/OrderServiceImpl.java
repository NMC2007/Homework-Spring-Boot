package com.example.session15.service;

import com.example.session15.model.dto.request.OrderCreateDTO;
import com.example.session15.model.dto.request.OrderItemRequestDTO;
import com.example.session15.model.entity.*;
import com.example.session15.repository.OrderRepository;
import com.example.session15.repository.ProductRepository;
import com.example.session15.repository.UserRepository;
import com.example.session15.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public Order create(OrderCreateDTO req, String email) {

        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setCreatedDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalMoney = BigDecimal.ZERO;

        for (OrderItemRequestDTO itemReq : req.getItems()) {

            Product product = productRepository.findById(itemReq.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(itemReq.getQuantity());
            item.setPriceBuy(product.getPrice());

            totalMoney = totalMoney.add(
                    product.getPrice().multiply(
                            BigDecimal.valueOf(itemReq.getQuantity())
                    )
            );

            orderItems.add(item);
        }

        order.setOrderItems(orderItems);
        order.setTotalMoney(totalMoney);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> myOrders(String email) {

        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return orderRepository.findByUserOrderByCreatedDateDesc(user);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateStatus(Long id, OrderStatus status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        return orderRepository.save(order);
    }
}