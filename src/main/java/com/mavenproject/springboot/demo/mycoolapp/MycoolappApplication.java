package com.mavenproject.springboot.demo.mycoolapp;

import com.mavenproject.springboot.demo.mycoolapp.dao.StudentDAO;
import com.mavenproject.springboot.demo.mycoolapp.entity.Student;
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

	// Inject StudentDAO to this bean
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryStudents(studentDAO);
			// specialQueryStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		if (numRowsDeleted == 0) {
			System.out.println("There's no data to be deleted.");
		} else {
			System.out.println("Deleting all students ...");
			System.out.println("Deleted rows: " + numRowsDeleted);
		}
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3001;
		Student myStudent = studentDAO.findById(studentId);
		if (myStudent == null) {
			System.out.println("There's no student with given ID: " + studentId);
		} else {
			studentDAO.delete(studentId);
			System.out.println("Deleting student with ID: " + studentId);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student by id
		int studentID = 3000;
		System.out.println("Getting student with id : " + studentID);
		Student myStudent = studentDAO.findById(studentID);

		// change firstName to "Scooby"
		myStudent.setFirstName("Hana");
		System.out.println("Updating student ...");

		// update the student
		Student student = studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Wangsaatmaja");

		for(Student student : theStudents) {
			System.out.println(student);
		}

	}

	private void specialQueryStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.specialFindAll();

		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		// create student
		System.out.println("Creating new student ...");
		Student tempStudent = new Student("Cita","Dwi","citadwip@gmail.com");

		// save
		System.out.println("Saving new student ...");
		studentDAO.save(tempStudent);

		// display id & name
		System.out.println("Saved. Generated id: " + tempStudent.getId());
		System.out.println("Student name: " + tempStudent.getFirstName());

		// read
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found the student: " + myStudent); // toString() method in class Student
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating new multiple student objects ...");
		Student tempStudent1 = new Student("Addina", "Wangsaatmaja","addinawangsaatmaja@gmail.com");
		Student tempStudent2 = new Student("Irsyad", "Ibrahim","irsyadibrahim@gmail.com");
		Student tempStudent3 = new Student("As-Zahrah", "Heinrich","sarah@gmail.com");

		// save the objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("Saving the students ...");

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Hani", "Maitssa","hani@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student ID: " + tempStudent.getId());
	}

}
