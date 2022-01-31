package com.techelevator;

//import com.techelevator.math.Fibonacci;

import com.techelevator.math.*;

import java.util.*;


public class FibonacciApp {

    public static void main(String[] args) {

        List<Integer> fibUpTo20 = Fibonacci.getFibonacciNumbers(20);
        System.out.println(fibUpTo20);

        List<Integer> fibUpTo1000000 = Fibonacci.getFibonacciNumbers(1_000_000);
        System.out.println(fibUpTo1000000);
    }
}
