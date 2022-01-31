package com.techelevator;

public class Address {
    private String address_LineOne;
    private String city;
    private String state;
    private int zipCode;

    public String getAddress_LineOne() {
        return address_LineOne;
    }

    public void setAddress_LineOne(String address_LineOne) {
        this.address_LineOne = address_LineOne;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
