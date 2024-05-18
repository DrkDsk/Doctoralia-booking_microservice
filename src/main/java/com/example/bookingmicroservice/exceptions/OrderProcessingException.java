package com.example.bookingmicroservice.exceptions;

import com.example.bookingmicroservice.dto.OrderItemDTO;

import java.util.List;

public class OrderProcessingException extends RuntimeException {

    private final List<OrderItemDTO> unavailableItems;

    public OrderProcessingException(String message, List<OrderItemDTO> unavailableItems) {
        super(message);
        this.unavailableItems = unavailableItems;
    }

    public List<OrderItemDTO> getUnavailableItems() {
        return unavailableItems;
    }
}
