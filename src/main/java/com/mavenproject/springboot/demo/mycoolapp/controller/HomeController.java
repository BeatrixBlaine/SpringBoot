package com.mavenproject.springboot.demo.mycoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    // create mapping for helloworld
    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("TheDate", java.time.LocalDateTime.now());

        // automatically look return "helloworld.html"
        return "helloworld";
    }

    // method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // method to process the HTML form
    @GetMapping("/processForm")
    public String processForm() {
        return "process-form";
    }

}
