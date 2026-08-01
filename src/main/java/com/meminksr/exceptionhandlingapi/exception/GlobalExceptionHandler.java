package com.meminksr.exceptionhandlingapi.exception;


import com.meminksr.exceptionhandlingapi.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),                 // Zaman: Şimdi
                HttpStatus.NOT_FOUND.value(),        // Kod: 404
                ex.getMessage(),                     // Mesaj: Bizim hataya verdiğimiz mesaj
                request.getRequestURI()              // Yol: İsteğin atıldığı adres (örn: /api/users/99)
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}