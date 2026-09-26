package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.dao.SubjectRepository;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import com.mavenproject.springboot.demo.mycoolapp.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService{

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(int id) {
        return subjectRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteById(int id) {

        Optional<Subject> subject = subjectRepository.findById(id);

        Subject tempSubject = null;

        if(subject.isPresent()) {
            tempSubject = subject.get();
        }

        for (Student student : tempSubject.getStudents()) {
            student.getSubjects().remove(tempSubject);
        }

        subjectRepository.deleteById(id);
    }
}
