package com.github.springdemo.coontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {

    @GetMapping("/home")
    public String home() {
        return "Welcome To Spring! " + LocalDateTime.now();
    }
}
