package com.mavenproject.springboot.demo.mycoolapp;

import com.mavenproject.springboot.demo.mycoolapp.rest.FunRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		// scanning all packages
		scanBasePackages = {"com.mavenproject.springboot.demo.mycoolapp", "util"}
)
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

}
