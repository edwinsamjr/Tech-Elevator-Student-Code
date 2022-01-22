package com.techelevator;

public class lectureMain {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Goodbye World!");

//        for (int i = 95; i <= 105; i++) {
//            int iSquared = i * i;
//            int iCubed = i * i * i;
//            System.out.format("%3d %5d %8d%n", i, iSquared, iCubed);
//            // System.out.println(i + " " + iSquared + " " + iCubed);
//        }
        boolean keepGoing = true;
        int i = 0;

        while (keepGoing) {
            i++;
            System.out.println(i);
            if (i >= 10) {
                keepGoing = false;
            }
        }

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

}
