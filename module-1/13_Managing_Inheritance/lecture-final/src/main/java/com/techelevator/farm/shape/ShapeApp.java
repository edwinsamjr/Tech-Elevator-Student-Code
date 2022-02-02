package com.techelevator.farm.shape;

public class ShapeApp {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 5);

        Shape[] shapes = new Shape[] {new Circle(30),
                new Triangle(10, 5),
                new Rectangle(23, 13)
        };

        for (Shape shape : shapes) {
            System.out.println(shape.getName() + " has area " + shape.getArea());
        }
    }
}
