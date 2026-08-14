package com.mavenproject.springboot.demo.mycoolapp.dao;

import com.mavenproject.springboot.demo.mycoolapp.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> specialFindAll();
    List<Student> findByLastName(String theLastName);
    void update(Student theStudent);

}
