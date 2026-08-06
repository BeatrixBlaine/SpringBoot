package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // retrieve a value from application.properties, assigning it to var myName
    @Value("${my.name}")
    private String myName;

    // define a private field for the dependency
    private Coach myCoach;

    // constructor for dependency injection
    @Autowired
    public FunRestController(Coach theCoach) {
        myCoach = theCoach;
    }

    // expose "/" return "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }


    // expose test endpoints
    @GetMapping("/name")
    public String getMyName() {
        return "My name is " + myName + " and I'm Spider-man";
    }

    // expose new endpoint for "workout"
    // experimenting Coach Interface
    // Method that return something from CricketCoach
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/weeklyworkout")
    public String getWeeklyWorkout() {
        return myCoach.getWeeklyWorkout();
    }


}
