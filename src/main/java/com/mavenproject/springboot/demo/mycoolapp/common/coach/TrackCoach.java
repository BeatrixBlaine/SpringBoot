package com.mavenproject.springboot.demo.mycoolapp.common.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;



@Component
public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void doStartupStuff() {
        System.out.println("This is PostConstruct: " + getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("This is PreDestroy: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Running hard 1000k";
    }

    @Override
    public String getWeeklyWorkout() {
        return "Pass the ball bruh!";
    }
}
