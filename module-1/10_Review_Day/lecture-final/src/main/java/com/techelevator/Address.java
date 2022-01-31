package com.techelevator;

public class Address {

    // Instance variables
    private String addressLineOne;
    private String city;
    private String state;
    private int zip;

    // Constructors

    // Getters and setters
    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    // Derived properties. getters that don't have an instance variable

    // Private helper methods
}
