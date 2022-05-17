package com.example.safeapplication.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RequestMapping("/")
@RestController
public class Controller {


    @Secured("ROLE_READ")
    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/secret-data")
    public String getSecretData() {
        return "secret data";
    }

    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/username")
    public String getName(String username) {
        return "OK, username";
    }
}
