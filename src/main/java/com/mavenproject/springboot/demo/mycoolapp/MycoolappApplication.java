package com.mavenproject.springboot.demo.mycoolapp;

import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import com.mavenproject.springboot.demo.mycoolapp.entity.StudentDetail;
import com.mavenproject.springboot.demo.mycoolapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(
		// scanning all packages
		scanBasePackages = {"com.mavenproject.springboot.demo.mycoolapp", "util"}
)
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

}
