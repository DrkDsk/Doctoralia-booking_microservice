package com.example.bookingmicroservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CreateOrderDTO {

    @NotEmpty(message = "Item List cannot be empty")
    private List<@Valid OrderItemDTO> itemList;
}
