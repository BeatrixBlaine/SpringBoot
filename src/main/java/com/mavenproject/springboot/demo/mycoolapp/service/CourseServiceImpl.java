package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.dao.CourseRepository;
import com.mavenproject.springboot.demo.mycoolapp.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {

        Optional<Course> tempCourse = courseRepository.findById(id);

        Course theCourse;

        if(tempCourse.isPresent()) {
            theCourse = tempCourse.get();
        } else {
            throw new RuntimeException("Course ID not found - " + id);
        }

        return theCourse;
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {

        Optional<Course> tempCourse = courseRepository.findById(id);

        if(tempCourse.isEmpty()) {
            throw new RuntimeException("Course ID not found - " + id);
        }

        courseRepository.deleteById(id);
    }
}
