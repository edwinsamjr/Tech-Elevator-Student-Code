package com.techelevator.game;

public class Card {

    private String rank;
    private String suit;

    public Card() {
        this.rank = "Ace";
        this.suit = "Spades";
    }

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
    }

}
