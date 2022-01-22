package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class LinearConvert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the length: ");
        String initialLength = scanner.nextLine();
        double lengthDouble = Double.parseDouble(initialLength);

        System.out.print("Is measurement in (M)eters or (F)eet? ");
        String metersOrFeet = scanner.nextLine();

        if (metersOrFeet.equals("M")){
            double lengthInFeet = lengthDouble * 3.2808399;
            System.out.printf("%6.2fM is %6.2fF.", lengthDouble, lengthInFeet);
        } else if (metersOrFeet.equals("F")){
            double lengthInMeters = lengthDouble * 0.3048;
            System.out.printf("%6.2fF is %6.2fM.", lengthDouble, lengthInMeters);
        }


    }

}
