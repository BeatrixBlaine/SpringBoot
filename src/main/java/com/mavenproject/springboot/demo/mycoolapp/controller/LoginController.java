package com.mavenproject.springboot.demo.mycoolapp.controller;

import com.mavenproject.springboot.demo.mycoolapp.dto.RegistrationRequest;
import com.mavenproject.springboot.demo.mycoolapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // remove leading and trailing white spaces
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute(
                "registrationRequest",
                new RegistrationRequest()
        );

        return "login/register";
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("registrationRequest")
            RegistrationRequest request,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "login/register";
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {

            model.addAttribute("error", "Passwords do not match");

            return "login/register";
        }

        boolean registered = userService.registerUser(
                request.getUsername(),
                request.getPassword()
        );

        if (!registered) {
            model.addAttribute("error", "Username is already taken.");
            return "login/register";
        }

        return "redirect:/login-page?registered";
    }

}
