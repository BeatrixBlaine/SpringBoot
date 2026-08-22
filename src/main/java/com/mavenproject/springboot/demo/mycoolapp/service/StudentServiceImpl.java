package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.dao.StudentDAO;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
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
    public void update(Student theStudent) {
        studentDAO.update(theStudent);
    }

    @Override
    public void delete(Integer id) {
        studentDAO.delete(id);
    }

    @Override
    public int deleteAll() {
        return studentDAO.deleteAll();
    }
}
