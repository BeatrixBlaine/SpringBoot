package com.mavenproject.springboot.demo.mycoolapp.common.bakery;

// without @Component, we create manually the bean in BakeryConfig
public class Croissant implements BakeryService{

    public Croissant() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getBake() {
        return "Bake a croissant!";
    }
}
