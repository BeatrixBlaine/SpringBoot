package com.mavenproject.springboot.demo.mycoolapp.config;

import com.mavenproject.springboot.demo.mycoolapp.common.bakery.BakeryService;
import com.mavenproject.springboot.demo.mycoolapp.common.bakery.Croissant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// don't forget annotations
@Configuration
public class BakeryConfig {

    // creating bean for Croissant class
    // custom name for beans "baking". Call it in the rest controller with qualifier
    @Bean("baking")
    public BakeryService croissant() {
        return new Croissant();
    }

}
