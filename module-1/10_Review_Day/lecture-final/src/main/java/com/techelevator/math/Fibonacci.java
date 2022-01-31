package com.techelevator.math;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static List<Integer> getFibonacciNumbers(int upTo) {
        List<Integer> fibNums = new ArrayList<>();

        fibNums.add(0);
        fibNums.add(1);

        while (fibNums.get(fibNums.size() - 1) <= upTo) {
            int nextNum = fibNums.get(fibNums.size() - 1) + fibNums.get(fibNums.size() - 2);
            if (nextNum <= upTo) {
                fibNums.add(nextNum);
            } else {
                break;
            }
        }

        return fibNums;
    }
}
