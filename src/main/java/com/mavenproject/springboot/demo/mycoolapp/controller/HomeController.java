package com.mavenproject.springboot.demo.mycoolapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // HttpServlet way to pass data
    @GetMapping("/processFormTwo")
    public String processForm(HttpServletRequest request, Model model) {

        // read the parameter from HTML form
        String theName = request.getParameter("employeeName");

        theName = theName.toUpperCase();

        String result = "Hello! " + theName;

        /* add attribute called "message" to be access in the process-form-2 */
        model.addAttribute("message", result);

        return "process-form-2";
    }

    // RequestParam way to pass data
    @GetMapping("/processFormThree")
    public String processForm(@RequestParam("employeeName") String theName, Model model) {

        theName = theName.toLowerCase();
        int length = theName.length();

        model.addAttribute("theName",theName);
        model.addAttribute("nameLength",length);

        return "process-form-3";
    }

}
