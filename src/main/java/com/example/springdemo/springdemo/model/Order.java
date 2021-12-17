package com.example.springdemo.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "orderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private Date orderDate;
    private String itemName;
    private Double itemPrice;
    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;
}
