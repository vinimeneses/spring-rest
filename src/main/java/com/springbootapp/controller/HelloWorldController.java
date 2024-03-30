package com.springbootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //HTTP GET request

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
