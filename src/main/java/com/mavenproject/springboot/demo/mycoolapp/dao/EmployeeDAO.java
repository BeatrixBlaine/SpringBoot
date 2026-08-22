package com.mavenproject.springboot.demo.mycoolapp.dao;

import com.mavenproject.springboot.demo.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
