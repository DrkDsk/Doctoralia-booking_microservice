package com.example.bookingmicroservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String orderNo;
    private BigDecimal price;
    private List<OrderItemDTO> itemList;
}
