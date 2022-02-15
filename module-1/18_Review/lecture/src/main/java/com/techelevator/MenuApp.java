package com.techelevator;

import com.techelevator.view.Menu;

public class MenuApp {

    public static final String RED = "red";
    public static final String GREEN = "green";
    public static final String BLUE = "blue";
    public static final String[] COLORS = new String[] {RED, GREEN, BLUE};

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);


//        String[] colors = new String[] {"red", "green", "blue"};


        String favoriteColor = (String)menu.getChoiceFromOptions(COLORS);
        System.out.println("You picked " + favoriteColor);

        switch (favoriteColor) {
            case RED:
                System.out.println("Do the red thing");
                break;
            case GREEN:
                System.out.println("Do the green thing");
                break;
            case BLUE:
                System.out.println("Do the blue thing");
                break;
        }

    }
}
/*
1.
2.
3.
4.
5.
6.
7.
8.
9.
10.
11.
12.







 */