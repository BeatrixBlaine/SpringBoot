package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.dao.StudentDAO;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional // Annotations for changing/updating a data in databases
    public void save(Student theStudent) {
        studentDAO.save(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> specialFindAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        return studentDAO.findByLastName(theLastName);
    }

    @Override
    @Transactional
    public Student update(Student theStudent) {
        return studentDAO.update(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        studentDAO.delete(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        studentDAO.deleteAll();
    }
}
