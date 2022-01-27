package com.techelevator;

public class Airplane {

    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    public Airplane() {

    }

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public String getPlaneNumber() {
        return this.planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return this.totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return this.bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return this.totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return this.bookedCoachSeats;
    }

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        int availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        int availableCoachSeats = totalCoachSeats - bookedCoachSeats;


        if (forFirstClass && (availableFirstClassSeats - totalNumberOfSeats >= 0)){
            bookedFirstClassSeats += totalNumberOfSeats;
            return true;
        } else if (!forFirstClass && (availableCoachSeats - totalNumberOfSeats >= 0)) {
            bookedCoachSeats += totalNumberOfSeats;
            return true;
        } else {
            return false;
        }
    }

}
