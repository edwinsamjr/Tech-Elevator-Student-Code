package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLateTest {

    @Test
    public void array_of_one_two_three() {
        SameFirstLast sameFirstLate = new SameFirstLast();
        int[] testArray = new int[] {1, 2, 3};
        boolean result = sameFirstLate.isItTheSame(testArray);
        Assert.assertFalse("An array of [1, 2, 3] incorrectly returns true", result);
    }

    @Test
    public void array_of_one_two_one() {
        SameFirstLast sameFirstLate = new SameFirstLast();
        int[] testArray = new int[] {1, 2, 1};
        boolean result = sameFirstLate.isItTheSame(testArray);
        Assert.assertTrue("An array of [1, 2, 1] incorrectly returns false", result);
    }

    @Test
    public void array_of_one_two_three_one() {
        SameFirstLast sameFirstLate = new SameFirstLast();
        int[] testArray = new int[] {1, 2, 3, 1};
        boolean result = sameFirstLate.isItTheSame(testArray);
        Assert.assertTrue("An array of [1, 2, 3, 1] incorrectly returns false", result);
    }

    @Test
    public void null_array() {
        SameFirstLast sameFirstLate = new SameFirstLast();
        int[] testArray = null;
        boolean result = sameFirstLate.isItTheSame(testArray);
        Assert.assertFalse("A null array incorrectly returns true", result);
    }

    @Test
    public void array_of_zero_five_four_zero() {
        SameFirstLast sameFirstLate = new SameFirstLast();
        int[] testArray = new int[] {0, 5, 4, 0};
        boolean result = sameFirstLate.isItTheSame(testArray);
        Assert.assertTrue("An array of [0, 5, 4, 0] incorrectly returns false", result);
    }

    @Test
    public void array_of_negative_five_three_negative_five() {
        SameFirstLast sameFirstLate = new SameFirstLast();
        int[] testArray = new int[] {-5, 3, -5};
        boolean result = sameFirstLate.isItTheSame(testArray);
        Assert.assertTrue("An array of [-5, 3, -5] incorrectly returns false", result);
    }

    @Test
    public void array_of_negative_five_three_five() {
        SameFirstLast sameFirstLate = new SameFirstLast();
        int[] testArray = new int[] {-5, 3, 5};
        boolean result = sameFirstLate.isItTheSame(testArray);
        Assert.assertFalse("An array of [-5, 3, 5] incorrectly returns true", result);
    }

}
