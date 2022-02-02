package com.techelevator.farm;

public final class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "Meow!");
    }

    @Override
    public String getFavoriteFood() {
        return "Fish";
    }

    // Can no longer override once FarmAnimal.getSound() is declared final
//    @Override
//    public String getSound() {
//        return "Meow!";
//    }
}
