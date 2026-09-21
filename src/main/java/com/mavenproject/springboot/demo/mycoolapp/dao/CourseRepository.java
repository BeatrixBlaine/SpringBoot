package com.mavenproject.springboot.demo.mycoolapp.dao;


import com.mavenproject.springboot.demo.mycoolapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
