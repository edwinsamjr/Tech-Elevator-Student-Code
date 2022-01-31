package com.techelevator.math;

import java.security.UnresolvedPermission;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static List<Integer> getFibonacciNumbers(int upTo) {
        List<Integer> fibonacciNums = new ArrayList<>();
        fibonacciNums.add(0);
        fibonacciNums.add(1);


        while (fibonacciNums.get(fibonacciNums.size() - 1) <= upTo) {
            int nextNum = (fibonacciNums.get(fibonacciNums.size() - 1)) + (fibonacciNums.get(fibonacciNums.size() - 2));
            if (nextNum <= upTo) {
                fibonacciNums.add(nextNum);
            } else {
                break;
            }
        }

        return fibonacciNums;
    }

}
