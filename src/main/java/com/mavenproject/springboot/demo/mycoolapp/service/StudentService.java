package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> specialFindAll();
    List<Student> findByLastName(String theLastName);
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();

}
