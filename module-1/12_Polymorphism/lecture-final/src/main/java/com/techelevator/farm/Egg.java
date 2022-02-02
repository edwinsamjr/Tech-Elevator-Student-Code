package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable {

    private BigDecimal price = new BigDecimal("0.35");

    public BigDecimal getPrice() {
        return price;
    }
}
