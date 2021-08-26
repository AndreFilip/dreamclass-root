package com.andreas.filippatos.dreamclassbackend.controllers;

import org.junit.jupiter.api.Test;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class WelcomeControllerTest extends BaseSpringBootTestController {

    @Test
    void getHelloFriend() throws Exception {
        mockMvc.perform(get("/welcome"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void getHelloFriendInside() throws Exception {
        mockMvc.perform(get("/welcome/inside"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void getHelloFriendInsideName() throws Exception {
        mockMvc.perform(get("/welcome/inside/Andrew"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void getHelloFriendInsideNameAuthorizedWithCreds() throws Exception {
        mockMvc.perform(get("/welcome/inside/Andrew").with(httpBasic("username1", "username1")))
                .andExpect(status().isOk());
    }

    @Test
    void getHelloFriendInsideNameUnauthorizedWithCreds() throws Exception {
        mockMvc.perform(get("/welcome/inside/Andrew").with(httpBasic("username1", "usernameWrongPass")))
                .andExpect(status().isUnauthorized());
    }
}