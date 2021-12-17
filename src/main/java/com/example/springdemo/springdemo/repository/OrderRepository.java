package com.example.springdemo.springdemo.repository;

import com.example.springdemo.springdemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByItemPriceBeforeOrderByItemPriceDesc(Double price);

    //Native query example
    @Query(nativeQuery = true, value = "select * from order_table where item_price > ?1")
    List<Order> findAllOrdersWherePriceIsGreaterThan(Double price);
}
