package com.hello.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.api.model.Survey;
import com.hello.api.service.SurveyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class HelloApiControllerSpec {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SurveyService surveyService;

    @Test
    void should_return_200_code_when_normal_case() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/hello"));
        result.andExpect(status().is2xxSuccessful());
    }

    @Test
    void should_return_survey_given_id_3() throws Exception {
        Survey expectSurvey = new Survey();
        expectSurvey.id = "3";
        expectSurvey.floor = "F6";

        when(surveyService.addSurvey(any())).thenReturn(expectSurvey);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .post("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectSurvey)));

        result
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(expectSurvey.id))
                .andExpect(jsonPath("$.floor").value(expectSurvey.floor));
    }

    static String asJsonString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
