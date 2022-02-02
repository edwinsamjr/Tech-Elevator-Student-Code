package com.techelevator.shape;

public class Triangle extends Shape {

    private int instanceNum;

    private int base;
    private int height;

    public Triangle(int base, int height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    public int getArea(){
        return base * height / 2;
    }

}
