package com.mavenproject.springboot.demo.mycoolapp.controller;

import com.mavenproject.springboot.demo.mycoolapp.entity.Employee;
import com.mavenproject.springboot.demo.mycoolapp.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee-form")
public class EmployeeFormController {

    // custom props
    @Value("${countries}")
    private List<String> countries;

    @Value("${gender}")
    private List<String> gender;

    @Value("${hobbies}")
    private List<String> hobbies;

    // Employee Service
    private final EmployeeService employeeService;

    // Employee Injection
    @Autowired
    public EmployeeFormController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add form data
    private void addFormData(Model model) {
        model.addAttribute("countries", countries);
        model.addAttribute("gender", gender);
        model.addAttribute("hobbies", hobbies);
    }

    // Initbinder - convert trim input strings
    // remove leading and trailing white spaces
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    // create mapping for helloworld
    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("TheDate", java.time.LocalDateTime.now());

        // automatically look return "helloworld.html"
        return "helloworld";
    }

    // method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm(Model model) {

        // add employee so it can be accessed by helloword-form.html
        model.addAttribute("employee", new Employee());
        addFormData(model);

        return "employee-form";
    }

    // method to process the HTML form
    @PostMapping("/processForm")
    public String processForm() {
        return "process-form";
    }

    // HttpServlet way to pass data
    @PostMapping("/processFormTwo")
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
    @PostMapping("/processFormThree")
    public String processForm(@RequestParam("employeeName") String theName, Model model) {

        theName = theName.toLowerCase();
        int length = theName.length();

        model.addAttribute("theName",theName);
        model.addAttribute("nameLength",length);

        return "process-form-3";
    }

    // Add new Employee, with @ModelAttribute, save it to databases
    @PostMapping("/processFormFour")
    public String processForm(@Valid @ModelAttribute("employee") Employee employee,
                              BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            addFormData(model);
            return "employee-form";
        }

        employeeService.save(employee);

        System.out.println("Saving new Employee . . .");
        System.out.println("Name : " + employee.getFirstName());

        return "process-form-4";
    }

    @GetMapping("/list")
    public String getAllEmployees(Model model) {

        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "list-employees";
    }

    @PostMapping("/new-employee")
    public String addNewEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult bindingResult, Model model) {
        return "process-form-5";
    }

}
