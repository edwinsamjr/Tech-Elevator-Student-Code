package com.techelevator;

public class SquareWall extends RectangleWall {

//    private int sideLength;
//
//    public SquareWall(String name, String color, int sideLength) {
//        super(name, color, sideLength, sideLength);
//        this.sideLength = sideLength;
//    }
//
//    public int getSideLength() {
//        return sideLength;
//    }
//
//    @Override
//    public int getArea() {
//        return sideLength * sideLength;
//    }
//
//    public String toString() {
//        return super.getName() + " (" + sideLength + "x" + sideLength + ") square";
//    }


    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength);
        sideLength = super.getLength();
    }

    public int getSideLength() {
        return super.getLength();
    }

    @Override
    public int getArea() {
        return super.getLength() * super.getLength();
    }

    public String toString() {
        return super.getName() + " (" + super.getLength() + "x" + super.getLength() + ") square";
    }
}
