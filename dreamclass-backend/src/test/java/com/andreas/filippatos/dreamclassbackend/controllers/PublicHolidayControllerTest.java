package com.andreas.filippatos.dreamclassbackend.controllers;

import com.andreas.filippatos.dreamclassbackend.entities.PublicHoliday;
import com.andreas.filippatos.dreamclassbackend.services.PublicHolidayService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(value = PublicHolidayController.class
//, excludeAutoConfiguration = SecurityAutoConfiguration.class
//            )
class PublicHolidayControllerTest extends BaseSpringBootTestController {

    @MockBean
    private PublicHolidayService publicHolidayServiceMock;

    // @WithMockUser
    @Test
    public void getAllPublicHolidaysTest() throws Exception {
        PublicHoliday p1 = PublicHoliday.builder().id(1L).date("2022-2-22").description("desc").build();
        List<PublicHoliday> publicHolidays = Arrays.asList(p1);

        when(publicHolidayServiceMock.getAllPublicHolidays()).thenReturn(publicHolidays);

        mockMvc.perform(get("/publicHolidays").with(httpBasic("username1", "username1")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].description", is("desc")))
                .andExpect(jsonPath("$[0].date", is("2022-2-22")));

    }

    @Test
    public void getAllPublicHolidaysUnauthenticatedTest() throws Exception {
        mockMvc.perform(get("/publicHolidays"))
                .andExpect(status().isUnauthorized());

    }

}