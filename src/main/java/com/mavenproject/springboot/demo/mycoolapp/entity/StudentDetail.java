package com.mavenproject.springboot.demo.mycoolapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "student_detail")
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="hobby")
    private String hobby;

    @Past(message = "Date of birth must be in the past")
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    public StudentDetail(){}

    public StudentDetail(String hobby, LocalDate dateOfBirth) {
        this.hobby = hobby;
        this.dateOfBirth = dateOfBirth;
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
