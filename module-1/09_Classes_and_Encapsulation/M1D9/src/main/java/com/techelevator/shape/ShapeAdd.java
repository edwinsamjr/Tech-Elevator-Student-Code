package com.techelevator.shape;

import org.w3c.dom.css.Rect;
import org.w3c.dom.ls.LSOutput;

public class ShapeAdd {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.setWidth(10);
        rect.setHeight(5);
        System.out.println(rect.getWidth());

        Rectangle rect2 = new Rectangle();
        rect2.setWidth(20);
        System.out.println(rect2.getWidth());

        System.out.println("Area of rect is " + rect.getArea());
        System.out.println("Perimeter of rect is " + rect.getPerimeter());

        rect.setHeight(15);
        System.out.println("After setting height to " + rect.getHeight());
        System.out.println("Area of rect is " + rect.getArea());
        System.out.println("Perimeter of rect is " + rect.getPerimeter());

        Rectangle rect3 = new Rectangle(20, 15);
        System.out.println("The area of rect3 is " + rect3.getArea());
        System.out.println("We've constructed " + Rectangle.getNumInstances() + " rectangles");

        System.out.println("PI = " + Math.PI);


    }


}
