package com.andreas.filippatos.dreamclassbackend.controllers;

import org.junit.jupiter.api.Test;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(value = AdminController.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest extends BaseSpringBootTestController {

    @Test
    public void getHelloAdminRootUnauthorizedTest() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isUnauthorized());

    }

    @Test
    public void getHelloAdminRootUnauthorizedWithWrongCredsTest() throws Exception {
        mockMvc.perform(get("/admin").with(httpBasic("admin", "adminWrongPass")))
                .andExpect(status().isUnauthorized());

    }

    @Test
    public void getHelloAdminRootAuthorizedTest() throws Exception {
        mockMvc.perform(get("/admin").with(httpBasic("admin1", "admin1")))
                .andExpect(status().isOk());

    }
}