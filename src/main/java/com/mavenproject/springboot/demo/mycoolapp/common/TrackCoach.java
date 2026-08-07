package com.mavenproject.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Running hard 1000k";
    }

    @Override
    public String getWeeklyWorkout() {
        return "Pass the ball bruh!";
    }
}
