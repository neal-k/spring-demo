package com.example.springdemo.springdemo.service;

import com.example.springdemo.springdemo.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
public interface UserService {
    Optional<User> getUserByEmail(String email);
    User addUser(User user);
    List<User> searchByName(String name);
}
