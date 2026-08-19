package com.mavenproject.springboot.demo.mycoolapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Staff")
public class Staff {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="position")
    private String position;

    @Column(name="address")
    private String address;

    // constructor
    public Staff() {

    }

    public Staff(String firstName, String lastName, String position, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.address = address;
    }

    // getter & setter
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
