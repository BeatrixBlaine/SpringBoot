package com.mavenproject.springboot.demo.mycoolapp.dto;

import jakarta.validation.constraints.NotBlank;

public class SubjectRequest {

    @NotBlank
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
