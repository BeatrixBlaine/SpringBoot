package com.mavenproject.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class PaypalPayment implements PaymentService{
    @Override
    public String pay() {
        return "This is paypal payment";
    }
}
