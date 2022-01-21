package com.techelevator;

public class Lecture {

    public static void main(String[] args) {
//        String greeting = "Hello";
//
//        final int NUM_PLANETS = 8;
//
//        String[] planets = new String[NUM_PLANETS];
//        planets[0] = "Mercury";
//
//        System.out.println(planets[0]);
//
//        int[] emptyArray = {};
//        System.out.println(emptyArray.length);
//        emptyArray[0] = 12;

        Lecture lecture = new Lecture();

        boolean result = lecture.returnCounterFromLoop();
        System.out.println(result);

        lecture.printMax();
        lecture.addEvens();
    }

    /*
    1. Return the created array
    */
    public int[] returnArray() {
        //int[] array = { 80, 8080, 443 };
        int[] array = new int[3];
        array[0] = 80;
        array[1] = 8080;
        array[2] = 443;
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = {80, 8080, 443};
        return portNumbers[0];
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = {80, 8080, 443};
//        int arrayLength = portNumbers.length;
//        int lastElement = portNumbers[arrayLength - 1];
        return portNumbers[portNumbers.length - 1];
    }

    /*
    4. Return the first element of the array from the parameters
    */
    public int returnFirstElementOfParam(int[] passedInArray) {
        return passedInArray[0];
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {
        return passedInArray[passedInArray.length - 1];
    }

    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
    */
    public int returnVariableFromBlock(int number) {

        int result;

        if (true) { // A new block with scoped variables

            result = number * 5;

            if (true) {
                System.out.println(result);
            }
        } // the result variable disappears here

        if (true) {
            String greeting = "Hello";
        }

        if (true) {
            String greeting = "Howdy";
        }


        return result; // We want to return result here. How?
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier;  // Same as result = result * multiplier;
        }

        return result == 50; // <-- Change the number to match result and make this be true
    }

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return one;
    }

    /*
    9. How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = {3, 4, 2, 9};

        int counter = 0; // Must be started outside the block so that have access to it after the block

        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter++;  // Same as counter += 1. Same as counter = counter + 1.
        }

        return counter == 1; // What should the number be to return true?
    }

    /*
    10. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = {4, 23, 9};

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;
    }

    /*
    11. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = {4, 23, 9, 4, 33};

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = {4, 3, 4, 1, 4, 6};

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i = i + 2) {
            sum = sum + arrayToLoopThrough[i];
        }

        return sum == 12;
    }

    public void printMax() {
        int[] values = { 45, 12, 32, 67, 97 };

        //int maxFound = 0;
        int maxFound = values[0];

        // Loop through values finding the biggest one
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxFound) {
                maxFound = values[i];
            }
            //maxFound = (values[i] > maxFound) ? values[i] : maxFound;
        }

        // Print the largest value found
        System.out.println(maxFound);
    }

    public void addEvens() {
        //      Indexes:  0   1   2   3   4
        int[] values = { 45, 12, 32, 67, 97 };

        int sumOfEvens = 0;

        // Loop through values summing the even values
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                sumOfEvens += values[i];
            }
        }

        // Print the sum
        System.out.println(sumOfEvens);
    }
}