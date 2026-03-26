package com.example.demo.service;

import com.example.demo.DTO.OrderDTO;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.util.EmailService;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final EmailService emailService;

    public OrderService(OrderRepository orderRepository,
                        EmailService emailService) {
        this.orderRepository = orderRepository;
        this.emailService = emailService;
    }

    public Order createOrder(OrderDTO dto) {

        Order order = new Order();
        order.setCustomerEmail(dto.getCustomerEmail());
        order.setAmount(dto.getAmount());
        order.setStatus("CREATED");

        Order savedOrder = orderRepository.save(order); // ✅ DB save

        try {
            emailService.sendBill(
                    savedOrder.getCustomerEmail(),
                    savedOrder.getAmount()
            );
            savedOrder.setStatus("BILL_SENT");
        } catch (Exception e) {
            savedOrder.setStatus("EMAIL_FAILED");

            // VERY IMPORTANT: log the real error
            e.printStackTrace();
        }

        return orderRepository.save(savedOrder); // ✅ NO 500 now
    }
}