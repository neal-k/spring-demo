package com.example.springdemo.springdemo.utils;

import com.example.springdemo.springdemo.model.Order;
import com.example.springdemo.springdemo.model.User;
import com.example.springdemo.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 * This class is to insert mock data as an example only
 */
@Component //Auto creates object and creates bean for dependency injection
public class MockData {
    private UserRepository userRepository;

    @Autowired
    public MockData(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.insertData();
    }

    private void insertData() {
        var user1 = User.builder()
                .name("Josh Turner")
                .email("josh@email.com")
                .orderList(generateOrders())
                .build();
        var user2 = User.builder()
                .name("Lee Brown")
                .email("lee@email.com")
                .orderList(generateOrders())
                .build();
        var user3 = User.builder()
                .name("Sam Smith")
                .email("sam@email.com")
                .orderList(generateOrders())
                .build();
        var user4 = User.builder()
                .name("Tina Turner")
                .email("tina@email.com")
                .orderList(generateOrders())
                .build();
        var user5 = User.builder()
                .name("Putin")
                .email("putin@russia.com")
                .orderList(generateOrders())
                .build();

        //Notice we are saving both user and order entities together
        this.userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
    }

    private static List<Order> generateOrders() {
        var orderList = new ArrayList<Order>();
        for(int i = 0; i < 5; i++) {

            var order = Order.builder()
                    .orderDate(Date.from(Instant.now().minus(i, ChronoUnit.DAYS)))
                    .itemName("Item " + i)
                    .itemPrice(10d+i)
                    .build();

            orderList.add(order);
        }
        return orderList;
    }


}
