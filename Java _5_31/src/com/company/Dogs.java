package com.company;

public class Dogs extends Animal{

    public double higth;

    @Override
    public void eat() {

    }

    public Dogs() {

    }

    public Dogs(String name, int age, double hight) {
        this.age = age;
        this.name = name;
        this.higth = hight;
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", higth=" + higth +
                '}';
    }


}
