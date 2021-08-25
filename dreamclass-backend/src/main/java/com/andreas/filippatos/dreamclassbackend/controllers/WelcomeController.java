package com.andreas.filippatos.dreamclassbackend.controllers;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping()
    public String getHelloFriend() {
        return "Hello Friend";
    }

    @GetMapping("/inside")
    public String getHelloFriend2() {
        return "Hello Friend Inside";
    }

    @GetMapping("/inside/{name}")
    public String getHelloFriend3(@PathVariable String name) {
        return "Hello " + name + " Inside";
    }
}
