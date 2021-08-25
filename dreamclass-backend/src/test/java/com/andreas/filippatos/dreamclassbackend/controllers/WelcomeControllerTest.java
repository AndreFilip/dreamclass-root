package com.andreas.filippatos.dreamclassbackend.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = WelcomeController.class)
class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getHelloFriend() throws Exception {
        this.mockMvc.perform(get("/welcome"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void getHelloFriend2() throws Exception {
        this.mockMvc.perform(get("/welcome/inside"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void getHelloFriend3() throws Exception {
        this.mockMvc.perform(get("/welcome/inside/Andrew"))
                .andExpect(status().isUnauthorized());
    }
}