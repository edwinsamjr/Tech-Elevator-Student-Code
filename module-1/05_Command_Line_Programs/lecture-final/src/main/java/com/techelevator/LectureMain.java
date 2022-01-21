package com.techelevator;

public class LectureMain {

    public static void main(String[] args) {
        System.out.print("Hello");
        System.out.println("Goodbye");

        for (int i = 95; i <= 105; i++) {
            int iSquared = i * i;
            int iCubed = i * i * i;
            //System.out.println(i + " " + iSquared + " " + iCubed);
            System.out.format("%3d %5d %8d%n", i, iSquared, iCubed);
        }

        double pi = 3.14159;
        System.out.format("%3.2f%n", pi);


        //
        // While loops
        //
        boolean keepGoing = true;
        int i = 0;

//        while (keepGoing) {
//            i++;
//            System.out.println(i);
//            if (i > 10) {
//                keepGoing = false;
//            }
//        }

        while (true) {
            i++;
            System.out.println(i);
            if (i > 10) {
                break;
            }
        }

        int j = 0;

        do {
            j++;
            System.out.println(j);
        } while (j < 10);

        String s1 = new String("Hello");
        String s2 = new String("HELLO");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String result = "";

        for (int x = 0; x < 10; x++) {
            result = Integer.toString(x) + result;
        }

        System.out.println(result);
    }
}
