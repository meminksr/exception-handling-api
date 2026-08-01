package com.meminksr.exceptionhandlingapi.service;

import com.meminksr.exceptionhandlingapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserById(Long id) {

        if (id == 99) {
            throw new ResourceNotFoundException("User not found in DB! Requested ID: " + id);
        }

        return "User fetched successfully. ID: " + id;
    }
}