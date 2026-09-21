package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.dto.CourseRequest;
import com.mavenproject.springboot.demo.mycoolapp.entity.Course;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import com.mavenproject.springboot.demo.mycoolapp.service.CourseService;
import com.mavenproject.springboot.demo.mycoolapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {

    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public CourseRestController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    // GET /api/courses
    @GetMapping("/courses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    // GET /api/courses/{id}
    @GetMapping("/courses/{id}")
    public Course findById(@PathVariable int id) {
        return courseService.findById(id);
    }

    // POST /api/courses
    @PostMapping("/courses")
    public Course addCourse(@RequestBody CourseRequest request) {

        Course course = new Course();
        course.setId(0);
        course.setTitle(request.getTitle());

        Student student = studentService.findById(request.getStudentId());
        course.setStudent(student);

        return courseService.save(course);
    }

    // PUT /api/courses
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    // DELETE /api/courses/{id}
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        Course course = courseService.findById(id);

        if (course == null) {
            throw new RuntimeException("Course ID not found - " + id);
        }

        courseService.deleteById(id);
    }
}
