package com.techelevator;

public class Television {

    private boolean isOn;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public Television() {

    }

    public boolean isOn() {
        return this.isOn;
    }

    public int getCurrentChannel() {
        return this.currentChannel;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }

    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
        currentVolume = 2;
        currentChannel = 3;
    }

    public void changeChannel(int newChannel) {
        if (isOn) {
            if (newChannel >= 3 && newChannel <= 18) {
                this.currentChannel = newChannel;
            }
        }
    }

    public void channelUp() {
        if (isOn) {
            if (currentChannel == 18) {
                currentChannel = 3;
            } else {
                currentChannel++;
            }
        }
    }

    public void channelDown() {
        if (isOn) {
            if (currentChannel == 3) {
                currentChannel = 18;
            } else {
                currentChannel--;
            }
        }
    }

    public void raiseVolume() {
        if (isOn) {
            if (currentVolume < 10) {
                currentVolume++;
            }
        }
    }

    public void lowerVolume() {
        if (isOn) {
            if (currentVolume > 0) {
                currentVolume--;
            }
        }
    }
}
