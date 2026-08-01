package com.meminksr.exceptionhandlingapi.controller;

import com.meminksr.exceptionhandlingapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Dependency Injection: Service katmanını Controller'a bağlıyoruz.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Şemadaki 1. Adım: İstemciden (Postman/Tarayıcı) gelen GET /api/users/99 isteğini burada karşılıyoruz.
    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}