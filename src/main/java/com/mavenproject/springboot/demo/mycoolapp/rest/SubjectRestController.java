package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.dto.SubjectRequest;
import com.mavenproject.springboot.demo.mycoolapp.entity.Subject;
import com.mavenproject.springboot.demo.mycoolapp.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectRestController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public List<Subject> getSubjects() {
        return subjectService.findAll();
    }

    @GetMapping("/subjects/{subjectId}")
    public Subject getSubject(@PathVariable int subjectId){
        return subjectService.findById(subjectId);
    }

    @PostMapping("/subjects")
    public Subject addSubject(@Valid @RequestBody SubjectRequest request) {

        Subject subject = new Subject();
        subject.setId(0);
        subject.setTitle(request.getTitle());

        return subjectService.save(subject);
    }

    @DeleteMapping("/subjects/{subjectId}")
    public String deleteSubject(@PathVariable int subjectId) {

        subjectService.deleteById(subjectId);

        return "Subject with id - " + subjectId + " deleted";
    }

}
