package com.techelevator.farm.shape;

public abstract class Shape {

    private static int numInstances = 0;

    private String name;

    public Shape(String name) {
        // Increment our instance counter
        numInstances++;

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getArea();
//    public int getArea() {
//        return 0;
//    }

    protected static int getNumInstances() {
        return numInstances;
    }
}
