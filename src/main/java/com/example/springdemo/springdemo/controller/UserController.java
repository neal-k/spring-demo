package com.example.springdemo.springdemo.controller;

import com.example.springdemo.springdemo.exception.NotFoundException;
import com.example.springdemo.springdemo.model.User;
import com.example.springdemo.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
@RequestMapping(value = "/api/user") // path to access this controller
@RestController //Specifies to spring, this is a rest controller so it auto adds response body to every endpoint
public class UserController {

    private final UserService userService;

    @Autowired //Dependency injection of UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{email}") // full path /api/user/something@email.com
    public User getUserByEmail(@PathVariable String email) {
        return this.userService.getUserByEmail(email).orElseThrow(NotFoundException::new);
    }

    @PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @GetMapping(value = "/search/{name}")
    public List<User> searchForUser(@PathVariable String name) {
        return this.userService.searchByName(name);
    }
}
