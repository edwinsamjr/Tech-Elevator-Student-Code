package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        //Created by manually passing Fibonacci numbers into an array

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Please enter a number between 1-1000: ");
//        String endingNumberStr = scanner.nextLine();
//
//        int endingNumber = Integer.parseInt(endingNumberStr);
//
//
//
//        int[] fibonacciSequence = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
//
//        int currentFibNumber = 0;
//
//        System.out.print("0");
//        for (int i = 1; i < fibonacciSequence.length; i++) {
//             if (currentFibNumber <= endingNumber) {
//                System.out.print(", " + fibonacciSequence[i]);
//                currentFibNumber = fibonacciSequence[i + 1];
//            }
//        }


        //Created by printing a series of sums

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        String endingNumberStr = scanner.nextLine();

        int endingNumber = Integer.parseInt(endingNumberStr);

        int number1 = 0;
        int number2 = 1;
        int sumOfPreviousTwo = number1 + number2;

        System.out.print(0);
        while (sumOfPreviousTwo <= endingNumber) {
            System.out.print(", " + sumOfPreviousTwo);
            sumOfPreviousTwo = number1 + number2;
            number1 = number2;
            number2 = sumOfPreviousTwo;

        }

    }

}
