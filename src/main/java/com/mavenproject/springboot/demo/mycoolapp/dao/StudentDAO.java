package com.mavenproject.springboot.demo.mycoolapp.dao;

import com.mavenproject.springboot.demo.mycoolapp.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);
}
