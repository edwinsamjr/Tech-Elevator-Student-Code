package com.techelevator.shape;

import java.util.Scanner;

public class ShapeApp {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 5);
        Shape[] shapes = new Shape[] {
                new Circle(30),
                new Triangle( 10,5 ),
                new Rectangle(23, 13)
        };

        for (Shape shape : shapes) {
            System.out.printf("%s has area of %s%n",shape.getName(), shape.getArea());;
        }


    }

}
