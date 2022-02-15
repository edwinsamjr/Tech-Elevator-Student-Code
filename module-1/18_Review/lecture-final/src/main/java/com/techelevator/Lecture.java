package com.techelevator;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

    public static void main(String[] arguments) {

        for (String argument : arguments) {
            System.out.println(argument);
        }

        if (1 == 2) {
            System.exit(10135);
            //return;
        }

        int[] nums = new int[]{1, 5, 7};

        int sum = 0;
        try {
            // int sum = 0; <-- Only has scope inside the try { }
            //for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (int i = 0; i < nums.length; ++i) {
                sum = sum + nums[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("We're done and sum is " + sum);
            // We're done
        }

        System.out.println("sum = " + sum);

    }

}
