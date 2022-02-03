package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    @Test
    public void array_of_one_two_four_returns_true() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = new int[] {0, 2, 4};
        boolean result = lucky13.getLucky(testArray);
        Assert.assertTrue("An array of [0,2,4] incorrectly results false", result);
    }

    @Test
    public void array_of_one_two_three_returns_false() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = new int[] {1, 2, 3};
        boolean result = lucky13.getLucky(testArray);
        Assert.assertFalse("An array of [1,2,3] incorrectly results true", result);
    }

    @Test
    public void array_of_one_two_four_returns_false() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = new int[] {1, 2, 4};
        boolean result = lucky13.getLucky(testArray);
        Assert.assertFalse("An array of [1,2,4] incorrectly results false", result);
    }

    @Test
    public void array_of_negative_one_two_four_returns_false() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = new int[] {1, 2, 4};
        boolean result = lucky13.getLucky(testArray);
        Assert.assertFalse("An array of [1,2,4] incorrectly results true", result);
    }

    @Test
    public void array_of_negative_one_two_three_returns_false() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = new int[] {-1, 2, 3};
        boolean result = lucky13.getLucky(testArray);
        Assert.assertFalse("An array of [-1,2,3] incorrectly results true", result);
    }

    @Test
    public void null_array_returns_true() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = null;
        boolean result = lucky13.getLucky(testArray);
        Assert.assertTrue("An null array incorrectly results false", result);
    }

    @Test
    public void array_of_three_three_three_returns_false() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = new int[] {3, 3, 3};
        boolean result = lucky13.getLucky(testArray);
        Assert.assertFalse("An array of [3,3,3] incorrectly results true", result);
    }

    @Test
    public void empty_array_returns_true() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = new int[]{};
        boolean result = lucky13.getLucky(testArray);
        Assert.assertTrue("An empty array incorrectly results false", result);
    }

}
