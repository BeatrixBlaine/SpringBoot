package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.entity.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> findAll();
    Staff findById(int id);
    Staff save(Staff staff);
    void deleteById(int id);

}
