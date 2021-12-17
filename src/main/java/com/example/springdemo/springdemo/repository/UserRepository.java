package com.example.springdemo.springdemo.repository;

import com.example.springdemo.springdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 * Extend JPA repository to start building queries using java methods
 * By extending JpaRepository, Spring will auto-implement when used with dependency injection (Check UserService)
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    List<User> findAllByNameContaining(String name);
}
