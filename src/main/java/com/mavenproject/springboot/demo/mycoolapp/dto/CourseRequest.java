package com.mavenproject.springboot.demo.mycoolapp.dto;

public class CourseRequest {

    private String title;
    private int studentId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
