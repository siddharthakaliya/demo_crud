package com.example.demo.controller;

import com.example.demo.DTO.OrderDTO;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Order createOrder(@Valid @RequestBody OrderDTO dto) {
        return orderService.createOrder(dto);
    }
}

