package com.techelevator.shape;

public class Circle extends Shape {

    private int radius;

    public Circle(int radius){
        super("Circle");
        this.radius= radius;
    }

    @Override
    public int getArea() {
        return (int) (radius * radius * Math.PI);
    }
}
