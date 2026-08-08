package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.common.Coach;
import com.mavenproject.springboot.demo.mycoolapp.common.PaymentService;
import com.mavenproject.springboot.demo.mycoolapp.common.PaypalPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Rest Controller returns the value as the HTTP response body. Not for returning a page
// for API
@RestController
public class FunRestController {

    // retrieve a value from application.properties, assigning it to var myName
    @Value("${my.name}")
    private String myName;

    // define a private field for the dependency
    private Coach myCoach;
    private PaymentService paymentService;

    // constructor injection
    @Autowired
    public FunRestController(@Qualifier("trackCoach") Coach theCoach) {
        System.out.println("The constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    // setter injection
    @Autowired
    public void setPaymentService(PaymentService thePaymentService) {
        paymentService = thePaymentService;
    }

    // expose "/" return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }


    // expose test endpoints
    @GetMapping("/name")
    public String getMyName() {
        return "My name is " + myName + " and I'm Spider-man";
    }

    // expose new endpoint for "workout"
    // experimenting Coach Interface
    // Method that return something from CricketCoach
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/weeklyworkout")
    public String getWeeklyWorkout() {
        return myCoach.getWeeklyWorkout();
    }

    // expose new endpoint payment
    // experimenting PaymentService Interface
    // Method that return from PaypalPayment
    @GetMapping("/paypalpayment")
    public String getPayment() {
        return paymentService.pay();
    }


}
