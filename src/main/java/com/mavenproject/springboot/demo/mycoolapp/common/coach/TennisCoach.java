package com.mavenproject.springboot.demo.mycoolapp.common.coach;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
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
