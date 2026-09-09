package com.mavenproject.springboot.demo.mycoolapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // @NotNull(message = " required field")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "First name can only contain letters and spaces")
    @NotBlank(message = "First name is required")
    @Column(name="first_name")
    private String firstName;

    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Last name can only contain letters and spaces")
    @NotBlank(message = "Last name is required")
    @Column(name="last_name")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email")
    @Column(name="email")
    private String email;

    @NotBlank(message = "Please select a country")
    @Column(name="country")
    private String country;

    @NotBlank(message = "Please select a gender")
    @Column(name="gender")
    private String gender;

    @NotEmpty(message = "Please select at least one hobby")
    @ElementCollection
    private List<String> hobby;


    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String email, String country, String gender, List<String> hobby) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.gender = gender;
        this.hobby = hobby;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
