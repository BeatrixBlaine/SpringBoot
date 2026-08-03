package com.mavenproject.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // retrieve a value from application.properties syntax, assigning it to var myName
    @Value("${my.name}")
    private String myName;

    // expose "/" return "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }


    // expose test endpoints
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    // expose new endpoint for "workout"
    @GetMapping("/workout")
    public String test2() {
        return "Run a hard 5k!";
    }
}
