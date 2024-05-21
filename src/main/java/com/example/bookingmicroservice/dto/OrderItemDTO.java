package com.example.bookingmicroservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class OrderItemDTO {

    @NotNull(message = "Code cannot be null")
    private String code;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

    @Positive(message = "Quantity must be greater than zero")
    @NotNull(message = "Quantity cannot be null")
    private Integer itemQuantity;
}
