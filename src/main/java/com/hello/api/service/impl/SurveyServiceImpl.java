package com.hello.api.service.impl;

import com.hello.api.model.Survey;
import com.hello.api.service.SurveyService;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Override
    public Survey addSurvey(final Survey survey) {
        return survey;
    }
}
