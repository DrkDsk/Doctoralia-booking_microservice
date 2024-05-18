package com.example.bookingmicroservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {
    private String code;
    private BigDecimal price;
    private Integer itemQuantity;
}
