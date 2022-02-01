package com.techelevator.calculator;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {

//        String someStr = "hello";
//
//        String firstLetterCapitalized = someStr.toUpperCase().substring(0, 1);
//
//        System.out.println(firstLetterCapitalized);

        CalculatorApp calculatorApp = new CalculatorApp();
        calculatorApp.run();
    }

    public void run() {
        System.out.println("Welcome to the Simple Calculator. This calculator adds two integers");

        Scanner userInputScanner = new Scanner(System.in);

//        System.out.println("Please enter the first number to add: ");
//        String firstValueStr = userInputScanner.nextLine();
//        int firstValue = Integer.parseInt(firstValueStr);
//        System.out.println("You entered " + firstValue);
//        System.out.println();
//
//        System.out.println("Please enter the second number to add: ");
//        String secondValueStr = userInputScanner.nextLine();
//        int secondValue = Integer.parseInt(secondValueStr);
//        System.out.println("You entered " + secondValue);
//        System.out.println();

        int firstValue = this.getIntFromUser("Please enter the first number to add: ", userInputScanner);
        int secondValue = this.getIntFromUser("Please enter the second number to add: ", userInputScanner);

        int result = firstValue + secondValue;
        System.out.println(firstValue + " + " + secondValue + " = " + result);
    }

    private int getIntFromUser(String prompt, Scanner userInputScanner) {
        System.out.println(prompt);
        String intValueStr = userInputScanner.nextLine();
        int intValue = Integer.parseInt(intValueStr);
        System.out.println("You entered " + intValue);
        System.out.println();

        return intValue;
    }
}
