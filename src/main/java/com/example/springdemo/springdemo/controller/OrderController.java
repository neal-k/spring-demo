package com.example.springdemo.springdemo.controller;

import com.example.springdemo.springdemo.model.Order;
import com.example.springdemo.springdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
@RequestMapping(value = "/api/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/belowPrice/{price}")
    public List<Order> getAllBelowPrice(@PathVariable Double price) {
        return this.orderService.getAllOrdersBelowPrice(price);
    }

    @GetMapping(value = "/abovePrice/{price}")
    public List<Order> getAllAbovePrice(@PathVariable Double price) {
        return this.orderService.getAllOrdersAbovePrice(price);
    }
}
