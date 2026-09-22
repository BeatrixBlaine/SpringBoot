package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.dto.StudentCourseRequest;
import com.mavenproject.springboot.demo.mycoolapp.dto.StudentRequest;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import com.mavenproject.springboot.demo.mycoolapp.exception.StudentNotFoundException;
import com.mavenproject.springboot.demo.mycoolapp.service.StudentService;
import jakarta.validation.Valid;
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
    public Student addStudent(@Valid @RequestBody StudentRequest request) {

        Student student = new Student();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudentDetail(request.getStudentDetail());

        studentService.save(student);

        return student;
    }

    @PutMapping("/students/{studentId}/courses")
    public Student assignCourses(
            @PathVariable int studentId,
            @RequestBody StudentCourseRequest request) {

        return studentService.assignCourses(studentId, request.getCourseIds());
    }

    @PostMapping("/students/batch")
    public List<Student> addStudents(@RequestBody List<Student> students) {

        for (Student student : students) {
            studentService.save(student);
        }

        return students;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        studentService.delete(studentId);

        return "Student deleted with id - " + studentId;
    }

    @PutMapping("/students/{studentId}")
    public Student student(@PathVariable int studentId,
                           @Valid @RequestBody Student student) {

        student.setId(studentId);

        return studentService.update(student);
    }


}
