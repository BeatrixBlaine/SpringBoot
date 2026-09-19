package com.mavenproject.springboot.demo.mycoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerPageController {

    @GetMapping("/index")
    public String home() {
        return "owner/index";
    }

}
