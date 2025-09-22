package com.cybage.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice  // Global exception handler
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleIllegalArgument(IllegalArgumentException ex) {
    	Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "CustomHeaderValue");
        
        return new ResponseEntity(errorResponse,headers,  HttpStatus.BAD_REQUEST);
//        return "Global Error: " + ex.getMessage();
    }

    @ExceptionHandler(Exception.class)  // Catch-all for other exceptions
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGenericException(Exception ex) {
        return "Something went wrong: " + ex.getMessage();
    }
}
