package com.mavenproject.springboot.demo.mycoolapp;

import com.mavenproject.springboot.demo.mycoolapp.dao.StudentDAO;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
import com.mavenproject.springboot.demo.mycoolapp.rest.FunRestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		// scanning all packages
		scanBasePackages = {"com.mavenproject.springboot.demo.mycoolapp", "util"}
)
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	// Inject StudentDAO to this bean
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Addina", "Wangsaatmaja","addinawangsaatmaja@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student ID: " + tempStudent.getId());
	}

}
