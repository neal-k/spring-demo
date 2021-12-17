package com.example.springdemo.springdemo.service;

import com.example.springdemo.springdemo.model.Order;

import java.util.List;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
public interface OrderService {
    List<Order> getAllOrdersBelowPrice(Double price);
    List<Order> getAllOrdersAbovePrice(Double price);
}
