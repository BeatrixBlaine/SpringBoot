package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.dao.CourseRepository;
import com.mavenproject.springboot.demo.mycoolapp.dao.StudentDAO;
import com.mavenproject.springboot.demo.mycoolapp.entity.Course;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import com.mavenproject.springboot.demo.mycoolapp.entity.Subject;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;
    private final CourseRepository courseRepository;
    private final SubjectService subjectService;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO,
                              CourseRepository courseRepository,
                              SubjectService subjectService) {
        this.studentDAO = studentDAO;
        this.courseRepository = courseRepository;
        this.subjectService = subjectService;
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

        Student student = studentDAO.findById(id);

        student.getSubjects().clear();

        studentDAO.delete(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        studentDAO.deleteAll();
    }

    @Override
    @Transactional
    public Student assignCourses(int studentId, List<Integer> courseIds) {

        Student student = studentDAO.findById(studentId);

        for (Integer courseId : courseIds) {

            Course theCourse = courseRepository.findById(courseId)
                    .orElseThrow(() ->
                            new RuntimeException("Course ID not found - " + courseId)
                    );

            theCourse.setStudent(student);
            courseRepository.save(theCourse);
        }

        return student;
    }

    @Override
    @Transactional
    public Student assignSubjects(int studentId, List<Integer> subjectIds) {

        Student tempStudent = studentDAO.findById(studentId);

        for (Integer subjectId : subjectIds) {

            Subject subject = subjectService.findById(subjectId);

            // checks if already exist
            if (!tempStudent.getSubjects().contains(subject)) {
                tempStudent.getSubjects().add(subject);
            }

        }

        studentDAO.save(tempStudent);

        return tempStudent;
    }

    @Override
    @Transactional
    public Student removeSubjects(int studentId, List<Integer> subjectIds) {

        Student student = studentDAO.findById(studentId);

        // declare a list
        List<Subject> subjectsToRemove = new ArrayList<>();

        // checks if the subjectIds is existed in the current pointed Student
        for(Subject subject : student.getSubjects()) {

            // add list of subject id (integer) to the declared List
            if(subjectIds.contains(subject.getId())) {
                subjectsToRemove.add(subject);
            }

        }

        // remove subjects from Student
        student.getSubjects().removeAll(subjectsToRemove);
        // save Student
        studentDAO.save(student);

        return student;
    }
}
