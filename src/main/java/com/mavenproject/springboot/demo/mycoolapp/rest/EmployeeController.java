package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.mavenproject.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeDAO.findAll();
    }
}
