package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.entity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> findAll();
    Subject findById(int id);
    Subject save(Subject subject);
    void deleteById(int id);

}
