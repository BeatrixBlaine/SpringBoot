package com.mavenproject.springboot.demo.mycoolapp.dto;

import java.util.List;

public class StudentCourseRequest {

    private List<Integer> courseIds;

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }

}
