package com.example.bookingmicroservice.client;

import com.example.bookingmicroservice.entities.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-microservice")
public interface StockClient {

    @RequestMapping("/api/stock/{code}/{quantity}")
    boolean available(@PathVariable String code, @PathVariable Integer quantity);
}
