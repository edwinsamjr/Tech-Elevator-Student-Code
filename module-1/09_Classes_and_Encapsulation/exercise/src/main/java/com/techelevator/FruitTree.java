package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int startingPiecesOfFruit;
    private int piecesOfFruitLeft;



    public FruitTree() {

    }

    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.startingPiecesOfFruit = startingPiecesOfFruit;
        piecesOfFruitLeft = startingPiecesOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (numberOfPiecesToRemove <= piecesOfFruitLeft){
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        } else {
            return false;
        }
    }



}
