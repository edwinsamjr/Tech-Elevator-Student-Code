package com.techelevator.reservations.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Reservation {

    private int id;

    @Min(value = 1, message = "must provide the hotel")
    private int hotelID;

    @NotBlank(message = "must provide guest name")
    private String fullName;

    @NotBlank(message = "nust provide a check-in date")
    private String checkinDate;

    @NotBlank(message = "nust provide a check-out date")
    private String checkoutDate;

    @Min(value = 1, message = "cannot have more than one guest")
    @Max(value = 5, message = "cannot have more than five guests")
    private int guests;

    public Reservation() {
    }

    public Reservation(int id, int hotelID, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelID = hotelID;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelID
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
