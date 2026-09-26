package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.dto.CourseRequest;
import com.mavenproject.springboot.demo.mycoolapp.dto.ReviewRequest;
import com.mavenproject.springboot.demo.mycoolapp.entity.Course;
import com.mavenproject.springboot.demo.mycoolapp.entity.Review;
import com.mavenproject.springboot.demo.mycoolapp.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {

    private final CourseService courseService;

    @Autowired
    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
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


        return courseService.save(course);
    }

    // PUT /api/courses
    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@PathVariable int courseId, @RequestBody CourseRequest request) {

        Course tempCourse = courseService.findById(courseId);

        tempCourse.setTitle(request.getTitle());

        return courseService.save(tempCourse);
    }

    // DELETE /api/courses/{id}
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
    }

    @PostMapping("/courses/{id}/reviews")
    public Course addReviews(@PathVariable int id,
                             @Valid @RequestBody ReviewRequest request) {

        // find the course
        Course tempCourse = courseService.findById(id);

        // input the comment
        tempCourse.getReviews().add(new Review(request.getComment()));

        return courseService.save(tempCourse);
    }

}
