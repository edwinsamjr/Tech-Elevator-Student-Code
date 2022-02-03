package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test
    public void array_of_one_two_three_returns_three_threes() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = new int[]{1, 2, 3};
        int[] result = maxEnd3.makeArray(testArray);
        int[] correctArray = new int[] {3, 3, 3};
        Assert.assertArrayEquals("The array entered does not match the expected array",correctArray, result);
    }

    @Test
    public void array_of_eleven_five_nine_returns_three_elevens() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = new int[]{11, 5, 9};
        int[] result = maxEnd3.makeArray(testArray);
        int[] correctArray = new int[] {11, 11, 11};
        Assert.assertArrayEquals("The array entered does not match the expected array",correctArray, result);
    }

    @Test
    public void array_of_zero_five_nine_returns_three_nines() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = new int[]{0, 5, 9};
        int[] result = maxEnd3.makeArray(testArray);
        int[] correctArray = new int[] {9, 9, 9};
        Assert.assertArrayEquals("The array entered does not match the expected array",correctArray, result);
    }

    @Test
    public void array_of_minus_ten_minus_twenty_five_minus_twenty_returns_three_minus_10s() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = new int[]{-10, -25, -20};
        int[] result = maxEnd3.makeArray(testArray);
        int[] correctArray = new int[] {-10, -10, -10};
        Assert.assertArrayEquals("The array entered does not match the expected array",correctArray, result);
    }

    @Test
    public void array_of_three_three_three_returns_three_threes() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = new int[]{3, 3, 3};
        int[] result = maxEnd3.makeArray(testArray);
        int[] correctArray = new int[] {3, 3, 3};
        Assert.assertArrayEquals("The array entered does not match the expected array",correctArray, result);
    }


}
