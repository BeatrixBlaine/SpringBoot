package com.mavenproject.springboot.demo.mycoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // create mapping for helloworld
    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("TheDate", java.time.LocalDateTime.now());

        // automatically look return "helloworld.html"
        return "helloworld";
    }
}
