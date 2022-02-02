package com.techelevator.shape;

public abstract class Shape {
    protected String name;
    private static int numInstances;

    public Shape(String name) {
        this.numInstances++;

        this.name = name;

    }

    public abstract int getArea();

    public String getName() {
        return name;
    }

    public static int getNumInstances() {
        return numInstances;
    }
}
