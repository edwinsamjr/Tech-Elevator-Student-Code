package com.techelevator.farm;

import java.math.BigDecimal;

public class Cat extends FarmAnimal {
    public Cat(){
        super("Cat", "meow!");
    }

    public String getFavoriteFood() {
        return "Fish";
    }

    //Can no longer override once FarmAnimal.getSound() is declared final
//    @Override
//    public String getSound() {
//        return "meow!";
//    }

}
