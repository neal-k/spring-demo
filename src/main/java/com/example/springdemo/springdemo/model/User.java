package com.example.springdemo.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * All classes/packages in spring boot will be below starting class with main method (SpringDemoApplication)
 */

@Builder // Lombok auto generate static builder method
@AllArgsConstructor // Lombok auto generate all argument constructor
@NoArgsConstructor // Lombok auto generate no args constructor
@Data // Lombok annotation that auto generates toString, required constructor, getter and setter methods
@Entity // This tells Hibernate to make a table out of this class (only for dev, don't use hibernate to auto-create in prod)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String name;
    private String email;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private List<Order> orderList;
}
