package com.techelevator.farm.card;

public class Card {

    private CardSuit suit;

    public Card(CardSuit suit) {
        this.suit = suit;
    }

    public CardSuit getSuit() {
        return suit;
    }
}
