package com.andreas.filippatos.dreamclassbackend.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getHelloRootUnauthorizedTest() throws Exception {
        this.mockMvc.perform(get("/admin"))
                .andExpect(status().isUnauthorized());

    }

    @Test
    public void getHelloRootUnauthorizedWithWrongCredsTest() throws Exception {
        this.mockMvc.perform(get("/admin").with(httpBasic("admin", "adminWrongPass")))
                .andExpect(status().isUnauthorized());

    }

    @Test
    public void getHelloRootAuthorizedTest() throws Exception {
        this.mockMvc.perform(get("/admin").with(httpBasic("admin", "admin")))
                .andExpect(status().isOk());

    }
}