package com.kivo.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Kivo API is running";
    }
    
}
