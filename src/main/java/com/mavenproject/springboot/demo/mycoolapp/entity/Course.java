package com.mavenproject.springboot.demo.mycoolapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = true)
    @JsonIgnore
    private Student student;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", nullable = true)
    private List<Review> reviews;

    public Course(){}

    public Course(String title) {
        this.title = title;
    }

    public Course(String title, Student student, List<Review> reviews) {
        this.title = title;
        this.student = student;
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", student=" + student +
                ", reviews=" + reviews +
                '}';
    }
}
