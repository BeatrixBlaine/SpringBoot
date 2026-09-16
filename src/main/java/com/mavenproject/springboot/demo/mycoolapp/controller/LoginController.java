package com.mavenproject.springboot.demo.mycoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home() {
        return "redirect:/login-page";
    }

    @GetMapping("/login-page")
    public String showLoginPage() {
        return "login/login-page";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "login/access-denied";
    }

}
