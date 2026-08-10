package com.mavenproject.springboot.demo.mycoolapp;

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

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hello World!");
		};
	}

}
