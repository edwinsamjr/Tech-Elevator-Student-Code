package com.techelevator.farm.shape;

public class Rectangle extends Shape {

    // The instance counter's value after this Rectangle is created
    private int instanceNum;

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
        this.instanceNum = Shape.getNumInstances();
    }

    public int getArea() {
        return width * height;
    }
}
