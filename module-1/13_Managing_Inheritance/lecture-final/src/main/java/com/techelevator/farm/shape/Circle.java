package com.techelevator.farm.shape;

public class Circle extends Shape {

    private int radius;

    public Circle(int radius) {
        super("Circle");
        this.radius = radius;
    }

    public int getArea() {
        return (int)(Math.PI * radius * radius);
    }

}
