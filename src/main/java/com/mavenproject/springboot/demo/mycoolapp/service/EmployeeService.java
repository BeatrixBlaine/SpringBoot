package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
