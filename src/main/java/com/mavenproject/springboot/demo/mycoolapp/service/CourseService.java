package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    Course findById(int id);
    Course save(Course course);
    void deleteById(int id);

}
