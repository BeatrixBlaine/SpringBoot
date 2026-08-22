package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.mavenproject.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
