package com.mavenproject.springboot.demo.mycoolapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

    // adding to application.log
    // private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // logging every save method
    @Before("execution(* com.mavenproject.springboot.demo.mycoolapp.service.*.save(..))")
    public void logBeforeSave() {
        // create logging in application.log
        // logger.debug(new StringBuilder().append(System.currentTimeMillis()).append(" Saving data ... ").toString());
        System.out.println("About to save data...");
    }

    // logging every update method
    @Before("execution(* com.mavenproject.springboot.demo.mycoolapp.service.*.update(..))")
    public void logBeforeUpdate() {
        System.out.println("About to update data...");
    }

}
