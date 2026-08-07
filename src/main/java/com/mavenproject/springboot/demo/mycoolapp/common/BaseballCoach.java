package com.mavenproject.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Plank 2 minutes a day!";
    }

    @Override
    public String getWeeklyWorkout() {
        return "Run 1 km!";
    }
}
