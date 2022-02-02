package com.techelevator.farm.card;

public class CardApp {

    public static void main(String[] args) {
        CardSuit someSuit = CardSuit.CLUBS;

        Card someCard = new Card(someSuit);

        if (someCard.getSuit() == CardSuit.CLUBS) {
            System.out.println("It's clubs");
        }

        switch (someCard.getSuit()) {
            case CLUBS:
                System.out.println("clubs");
                break;
            case HEARTS:
                System.out.println("hearts");
                break;
        }
    }
}
