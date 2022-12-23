package com.soma.test.infrastructure.input.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String PRICE_PATH = "/price/find";


    @Test
    void when_request_is_sent_ok_is_given() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(PRICE_PATH)
                        .queryParam("date", "2020-06-14 16:00:00")
                        .queryParam("product", "35455")
                        .queryParam("brand", "1"))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk());
    }

    @Test
    void when_request_is_sent_and_product_not_exists_not_found_is_given() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(PRICE_PATH)
                        .queryParam("date", "2020-06-14 16:00:00")
                        .queryParam("product", "1111")
                        .queryParam("brand", "1"))
                .andExpect(MockMvcResultMatchers.status()
                        .isNotFound());
    }
}