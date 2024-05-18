package com.example.bookingmicroservice.services;

import com.example.bookingmicroservice.dto.OrderDTO;
import com.example.bookingmicroservice.dto.OrderItemDTO;
import com.example.bookingmicroservice.entities.Item;
import com.example.bookingmicroservice.entities.Order;
import com.example.bookingmicroservice.entities.OrderItem;
import com.example.bookingmicroservice.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDTO orderDTO) {

        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orderDTO.getItemList()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setItemQuantity(orderItemDTO.getItemQuantity());
            orderItems.add(orderItem);
        }

        order.setOrderNo(UUID.randomUUID().toString());
        order.setOrderItems(orderItems);

        return orderRepository.save(order);
    }

}
