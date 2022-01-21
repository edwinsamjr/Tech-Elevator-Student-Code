package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountStr = scanner.nextLine();
        double discount = Double.parseDouble(discountStr);
        //System.out.format("%5.3f%n", discount);

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesStr = scanner.nextLine();
        String[] prices = pricesStr.split(" ");

        System.out.println("  Discount     Amount    Discount Amt");
        for (int i = 0; i < prices.length; i++) {
            double price = Double.parseDouble(prices[i]);
            double discountAmount = price * (discount / 100.0);
            System.out.format("%10.2f %10.2f %10.2f%n", discount, price, discountAmount);
        }
//
//        double price = Double.parseDouble(prices[0]);
//
//        double discountAmount = price * (discount / 100.0);
//
//        System.out.format("A discount of %3.2f%% on a $%8.2f item is $%8.2f", discount, price, discountAmount);

        Integer.parseInt("123");
    }

}