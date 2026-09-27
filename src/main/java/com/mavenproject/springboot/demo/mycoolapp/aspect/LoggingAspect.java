package com.mavenproject.springboot.demo.mycoolapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    // logging every save method
    @Before("execution(* com.mavenproject.springboot.demo.mycoolapp.service.*.save(..))")
    public void logBeforeSave() {
        System.out.println("About to save data...");
    }

}
