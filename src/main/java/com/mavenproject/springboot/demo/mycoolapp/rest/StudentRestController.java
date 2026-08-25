package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import com.mavenproject.springboot.demo.mycoolapp.exception.StudentNotFoundException;
import com.mavenproject.springboot.demo.mycoolapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final StudentService studentService;// make sure it's final

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student student = studentService.findById(studentId);

        if (student == null) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }

        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        studentService.save(student);

        return student;
    }

    @PostMapping("/students/batch")
    public List<Student> addStudents(@RequestBody List<Student> students) {

        for (Student student : students) {
            studentService.save(student);
        }

        return students;
    }


}
