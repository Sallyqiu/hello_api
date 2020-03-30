package com.hello.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class HelloApiControllerSpec {
    @Autowired
    MockMvc mockMvc;

    @Test
    void should_return_200_code_when_normal_case() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/hello"));
        result.andExpect(status().is2xxSuccessful());
    }
}
