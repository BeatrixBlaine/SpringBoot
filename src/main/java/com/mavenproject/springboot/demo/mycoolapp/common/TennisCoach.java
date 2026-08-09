package com.mavenproject.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }



    @Override
    public String getDailyWorkout() {
        return "Warming up before play";
    }

    @Override
    public String getWeeklyWorkout() {
        return "Play tennis 24 hours!";
    }
}
