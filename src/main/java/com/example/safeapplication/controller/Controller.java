package com.example.safeapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class Controller {

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/secret-data")
    public String getSecretData() {
        return "secret data";
    }
}
