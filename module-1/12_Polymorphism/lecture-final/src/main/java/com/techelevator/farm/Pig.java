package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal {

    public Pig() {
        super("Pig", "oink!", new BigDecimal("750.00"));
    }

    @Override
    public String getAOrAn() {
        return "an";
    }
}
