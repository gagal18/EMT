package com.finki.lab1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("swaggerExample")
public class ExampleController{

    @GetMapping()
    public Integer getExamples() {
        return 123;
    }
}