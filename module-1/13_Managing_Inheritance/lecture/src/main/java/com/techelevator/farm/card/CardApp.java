package com.techelevator.farm.card;

public class CardApp {

    public static void main(String[] args) {
        CardSuit someSuit = CardSuit.CLUBS;

        Card someCard = new Card(someSuit);

        if (someCard.getSuit() == CardSuit.CLUBS) {
            System.out.println("Let's go clubbing!");
        }

        switch (someCard.getSuit()) {
            case HEARTS:
                System.out.println("hearts");
                break;
            case SPADES:
                System.out.println("spades");
                break;
            case CLUBS:
                System.out.println("clubs");
                break;
            case DIAMONDS:
                System.out.println("diamonds");
                break;
             }

    }

}
