package com.techelevator;


import java.util.Scanner;

public class TempConvert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the temperature: ");
        String rawTemp = scanner.nextLine();
        double tempDouble = Double.parseDouble(rawTemp);

        System.out.print("Is temperature (C)elsius or (F)ahrenheit? ");
        String celsiusOrFahrenheit = scanner.nextLine();

        if (celsiusOrFahrenheit.equals("C")) {
            double temperatureFahrenheit = (tempDouble * 1.8) + 32;
            System.out.printf("%2.1fC is %2.1fF", tempDouble, temperatureFahrenheit);
        } else if (celsiusOrFahrenheit.equals("F")) {
            double temperatureCelsius = (tempDouble - 32) / 1.8;
            System.out.printf("%2.1fF is %2.1fC.", tempDouble, temperatureCelsius);
        }


    }

}

