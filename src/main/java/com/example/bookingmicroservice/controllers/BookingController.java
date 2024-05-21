package com.example.bookingmicroservice.controllers;

import com.example.bookingmicroservice.client.StockClient;
import com.example.bookingmicroservice.dto.CreateOrderDTO;
import com.example.bookingmicroservice.dto.OrderDTO;
import com.example.bookingmicroservice.entities.Order;
import com.example.bookingmicroservice.resources.ApiResource;
import com.example.bookingmicroservice.services.OrderService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("api/booking")
@NoArgsConstructor
public class BookingController {

    private OrderService orderService;
    private StockClient stockClient;

    @Autowired
    public BookingController(OrderService orderService, StockClient stockClient) {
        this.orderService = orderService;
        this.stockClient = stockClient;
    }

    @GetMapping
    public String index() {
        return "hello world";
    }

    @PostMapping("/order")
    //@CircuitBreaker(name = "saveOrder", fallbackMethod = "fallbackSaveOrder")
    public ApiResource<OrderDTO> saveOrder(@Valid @RequestBody CreateOrderDTO createOrderDTO) {

        /*List<OrderItemDTO> itemsNotExists = orderDTO.getItemList().stream().filter(item ->
                !stockClient.available(
                        item.getCode(),
                        item.getItemQuantity()
                )).toList();

        if (!itemsNotExists.isEmpty()) {
            throw new OrderProcessingException("Stock not available to these items", itemsNotExists);
        }*/

        Order order = orderService.createOrder(createOrderDTO);
        OrderDTO orderCreatedDTO = orderService.convertOrderToDTO(order);
        orderCreatedDTO.setItemList(createOrderDTO.getItemList());

        return new ApiResource.Builder<OrderDTO>()
                .success(true)
                .message("order created successfully")
                .data(orderCreatedDTO)
                .build();
    }

    public String fallbackSaveOrder(Exception exception) {
        return "Fallback Stock" + exception.getMessage();
    }

}
