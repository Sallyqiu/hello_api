package com.hello.api.controller;

import com.hello.api.model.Survey;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

    @PostMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    Survey addMethod(@RequestBody Survey survey) {
        return survey;
    }
}
