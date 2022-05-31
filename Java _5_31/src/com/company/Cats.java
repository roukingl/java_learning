package com.company;

public class Cats extends Animal{

    @Override
    public void eat() {
        System.out.println("maochi");
    }

    public Cats() {
    }

    public Cats(String name, int age) {
        super(name, age);
    }


}
