package com.mavenproject.springboot.demo.mycoolapp.dto;

import com.mavenproject.springboot.demo.mycoolapp.entity.StudentDetail;

public class StudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private StudentDetail studentDetail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }
}
