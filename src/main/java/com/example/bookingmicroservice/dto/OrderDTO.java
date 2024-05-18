package com.example.bookingmicroservice.dto;

import com.example.bookingmicroservice.entities.Item;
import com.example.bookingmicroservice.entities.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private List<OrderItemDTO> itemList;
}
