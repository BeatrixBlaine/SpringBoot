package com.mavenproject.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" return "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/home")
    public String home() {
        return "this is home";
    }

    @GetMapping("/contact")
    public String contact() {
        return "this is contact";
    }

}
