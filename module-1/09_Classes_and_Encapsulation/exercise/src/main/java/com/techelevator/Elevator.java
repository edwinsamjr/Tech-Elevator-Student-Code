package com.techelevator;

public class Elevator {

    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;


    public Elevator() {

    }

    public Elevator(int numberOfLevels) {
        numberOfFloors = numberOfLevels;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public boolean isDoorOpen() {
        return this.doorOpen;
    }

    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (desiredFloor > currentFloor && desiredFloor <= numberOfFloors && !doorOpen) {
            currentFloor = desiredFloor;
        }
    }

    public void goDown(int desiredFloor) {
        if (desiredFloor > 0 && desiredFloor < currentFloor && !doorOpen) {
            currentFloor = desiredFloor;
        }
    }

}
