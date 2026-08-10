package com.mavenproject.springboot.demo.mycoolapp.common.coach;

import org.springframework.stereotype.Component;

@Component
// Use @Lazy for faster startup and if the object is never used
// so the bean would not created
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "25x Pushup";
    }

    @Override
    public String getWeeklyWorkout() {
        return "100x Pushup";
    }
}
