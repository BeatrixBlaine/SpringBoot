package com.mavenproject.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "25x Pushup";
    }

    @Override
    public String getWeeklyWorkout() {
        return "100x Pushup";
    }
}
