package com.techelevator.shape;

public class Rectangle {

    public static final String SHAPE_NAME = "Rectangle";

    public static final int NUM_SIDES = 4;

    // static, shared across all instances of Rectangles
    private static int numInstances;

    // Instance variables. Created for each instance of Rectangle
    private int width;
    private int height;
    private String label;

    // Constructors
    public Rectangle() {
        //System.out.println("Default constructing a Rectangle");
        //numInstances++;
        this(0, 0); // Calls Rectangle(int width, int height) with zeroes
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public static int getArea(int width, int height) {
        return width * height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        if (width >= 0) {
            this.width = width;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        if (height >= 0) {
            this.height = height;
        }
    }

    public int getArea() {
        return this.width * this.height;
    }

    public int getPerimeter() {
        return (this.width * 2) + (this.height * 2);
    }

    public boolean isSquare() {
        return this.width == this.height;
    }
}
