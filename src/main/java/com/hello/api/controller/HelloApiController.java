package com.hello.api.controller;

import com.hello.api.model.Survey;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

    @PostMapping("/hello")
    Survey addMethod() {
        return new Survey();
    }
}
