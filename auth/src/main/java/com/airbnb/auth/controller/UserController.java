package com.airbnb.auth.controller;

import com.airbnb.auth.entity.User;
import com.airbnb.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registration(@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verifyUser(user);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);

    }
}
