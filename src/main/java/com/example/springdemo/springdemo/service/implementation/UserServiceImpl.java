package com.example.springdemo.springdemo.service.implementation;

import com.example.springdemo.springdemo.model.User;
import com.example.springdemo.springdemo.repository.UserRepository;
import com.example.springdemo.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
@Service //Setting up service for dependency injection
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired //Dependency injection with Spring
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User addUser(User user) {
        // Save is auto-implemented by JPA
        return this.userRepository.save(user);
    }

    @Override
    public List<User> searchByName(String name) {
        return this.userRepository.findAllByNameContaining(name);
    }
}
