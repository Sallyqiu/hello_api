package com.hello.api.controller;

import com.hello.api.model.Survey;
import com.hello.api.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

    final SurveyService surveyService;

    @Autowired
    public HelloApiController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    Survey addMethod(@RequestBody Survey survey) {
        return surveyService.addSurvey(survey);
    }
}
