package com.hello.api.controller;

import com.hello.api.model.Survey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    void should_return_survey_given_id_3() throws Exception {
        Survey expectSurvey = new Survey();
        expectSurvey.id = "3";

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/hello"));
        result
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(expectSurvey.id));
    }
}
