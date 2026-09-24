package com.mavenproject.springboot.demo.mycoolapp.dto;

import com.mavenproject.springboot.demo.mycoolapp.entity.Review;
import jakarta.validation.constraints.NotBlank;

public class ReviewRequest {

    @NotBlank
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
