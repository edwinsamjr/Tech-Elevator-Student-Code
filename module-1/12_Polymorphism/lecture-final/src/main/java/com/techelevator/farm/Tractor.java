package com.techelevator.farm;

public class Tractor implements Singable {

    private String name = "Tractor";
    private String sound = "Vroom!";
    private String aOrAn = "a";

    public String getName() {
        return this.name;
    }

    public String getSound() {
        return this.sound;
    }

    public String getAOrAn() {
        return this.aOrAn;
    }
}
