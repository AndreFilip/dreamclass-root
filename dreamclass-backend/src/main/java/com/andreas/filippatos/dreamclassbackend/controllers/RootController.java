package com.andreas.filippatos.dreamclassbackend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping()
    public String getHelloRoot() {
        return "Hello root";
    }
}
