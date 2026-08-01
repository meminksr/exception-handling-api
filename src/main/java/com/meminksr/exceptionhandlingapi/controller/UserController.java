package com.meminksr.exceptionhandlingapi.controller;

import com.meminksr.exceptionhandlingapi.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.meminksr.exceptionhandlingapi.dto.UserCreateRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public String createUser(@Valid @RequestBody UserCreateRequest request) {
        return "User created successfully: " + request.getName();
    }
}