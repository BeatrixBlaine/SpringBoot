package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.dao.StudentDAO;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import com.mavenproject.springboot.demo.mycoolapp.exception.StudentErrorResponse;
import com.mavenproject.springboot.demo.mycoolapp.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final StudentDAO studentDAO;// make sure it's final

    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentDAO.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student student = studentDAO.findById(studentId);

        if (student == null) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }

        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        studentDAO.save(student);

        return student;
    }

}
