package com.techelevator;

public class MovingElevator {

    public static void main(String[] args) {
        Elevator newElev = new Elevator(6);
        newElev.openDoor();
        newElev.closeDoor();
        newElev.goUp(3);
        newElev.goDown(2);
        System.out.println(newElev.getCurrentFloor());

    }

}
