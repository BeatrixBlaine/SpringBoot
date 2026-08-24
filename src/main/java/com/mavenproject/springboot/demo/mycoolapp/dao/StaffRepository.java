package com.mavenproject.springboot.demo.mycoolapp.dao;

import com.mavenproject.springboot.demo.mycoolapp.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
