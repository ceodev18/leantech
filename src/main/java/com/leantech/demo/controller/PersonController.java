package com.leantech.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "DO NOT USE")
public class PersonController {
    @GetMapping("/test")
    public String createBusinessCategory() {
        return "output";
    }
}

