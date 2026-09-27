package com.mavenproject.springboot.demo.mycoolapp.config;

import com.mavenproject.springboot.demo.mycoolapp.aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
