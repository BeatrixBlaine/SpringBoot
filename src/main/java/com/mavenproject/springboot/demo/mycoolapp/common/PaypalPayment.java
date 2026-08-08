package com.mavenproject.springboot.demo.mycoolapp.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// use @Primary if u want this beans to always used on the rest controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PaypalPayment implements PaymentService{
    @Override
    public String pay() {
        return "This is paypal payment";
    }
}
