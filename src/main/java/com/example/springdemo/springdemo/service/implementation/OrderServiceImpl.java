package com.example.springdemo.springdemo.service.implementation;

import com.example.springdemo.springdemo.model.Order;
import com.example.springdemo.springdemo.repository.OrderRepository;
import com.example.springdemo.springdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrdersBelowPrice(Double price) {
        return this.orderRepository.findAllByItemPriceBeforeOrderByItemPriceDesc(price);
    }

    @Override
    public List<Order> getAllOrdersAbovePrice(Double price) {
        return this.orderRepository.findAllOrdersWherePriceIsGreaterThan(price);
    }
}
