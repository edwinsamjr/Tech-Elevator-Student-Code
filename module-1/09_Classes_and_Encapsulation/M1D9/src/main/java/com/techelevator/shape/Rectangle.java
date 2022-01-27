package com.techelevator.shape;

public class Rectangle {

    private static int numInstances;

    private int width;
    private int height;

    public Rectangle() {
//        System.out.println("Default constructing a Rectangle");
//        numInstances++;

        this(0, 0);
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        numInstances++;
    }

    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        }

    }

    public int getHeight() {
        return this.height;
    }

    public int getArea() {
        return this.height * this.width;
    }

    public int getPerimeter() {
        return (this.height * 2) + (this.width * 2);
    }

    public boolean isSquare() {
        return this.width == this.height;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public static int getArea(int width, int height) {
        return width * height;
    }

}
