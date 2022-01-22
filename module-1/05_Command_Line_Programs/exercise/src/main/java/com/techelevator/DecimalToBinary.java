package com.techelevator;

import java.util.Scanner;

import static java.lang.Math.log;

public class DecimalToBinary {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a decimal value: ");
        String initialValueStr = scanner.nextLine();


        String[] decimalsString = initialValueStr.split(" ");

        //Thanks for the modulo hint in lecture!

        for (int i = 0; i < decimalsString.length; i++) {
            int modNumber = Integer.parseInt(decimalsString[i]);
            String finalString = "";

            while (modNumber > 0) {
                String numToAdd = String.valueOf((modNumber % 2));
                finalString = numToAdd + finalString;
                modNumber /= 2;
            }

            System.out.println(decimalsString[i] + " in binary is " + finalString);

        }


        /*My initial idea that worked for odd numbers but not for even ones because of the
        extra zeroes on the end. I looked up how to do log and power functions and spent way
        too much time down this rabbit hole.
         */

//        int value = Integer.parseInt(initialValueStr);
//        int logTwo = (int) ((Math.log(value)) / Math.log(2));
//        int powerTwo = (int) Math.pow(2, logTwo);
//
//
//        int remainingNum = value;
//        while (remainingNum > 0) {
//            if ( ((remainingNum - powerTwo) >= 0) && (powerTwo > 0) ) {
//                System.out.print(1);
//                remainingNum -= powerTwo;
//                powerTwo /= 2;
//            } else if (powerTwo > 0) {
//                System.out.print(0);
//                powerTwo /= 2;
//            } else if (powerTwo == 1 && remainingNum == 1){
//                System.out.println(1);
//                break;
//            } else {
//                break;
//            }
//        }

    }

}
