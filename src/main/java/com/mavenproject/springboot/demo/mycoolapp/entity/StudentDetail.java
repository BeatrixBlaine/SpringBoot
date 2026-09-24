package com.mavenproject.springboot.demo.mycoolapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

@Entity
@Table(name = "student_detail")
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message = "Hobby is required")
    @Column(name="hobby")
    private String hobby;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    // Bi-directional, can be remove safely if you want Uni-directional
    @OneToOne(mappedBy = "studentDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    private Student student;

    public StudentDetail(){}

    public StudentDetail(String hobby, LocalDate dateOfBirth) {
        this.hobby = hobby;
        this.dateOfBirth = dateOfBirth;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public @Past(message = "Date of birth must be in the past") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@Past(message = "Date of birth must be in the past") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", hobby='" + hobby + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
