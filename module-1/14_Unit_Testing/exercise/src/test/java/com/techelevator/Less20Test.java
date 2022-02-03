package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    @Test
    public void zero_return_false() {
        Less20 less20 = new Less20();
        boolean result = less20.isLessThanMultipleOf20(0);
        Assert.assertFalse("0 incorrectly returned true", result);
    }

    @Test
    public void seventeen_returns_false() {
        Less20 less20 = new Less20();
        boolean result = less20.isLessThanMultipleOf20(17);
        Assert.assertFalse("17 incorrectly returned true", result);
    }

    @Test
    public void eighteen_returns_true() {
        Less20 less20 = new Less20();
        boolean result = less20.isLessThanMultipleOf20(18);
        Assert.assertTrue("18 incorrectly returned false", result);
    }

    @Test
    public void nineteen_returns_true() {
        Less20 less20 = new Less20();
        boolean result = less20.isLessThanMultipleOf20(19);
        Assert.assertTrue("19 incorrectly returned false", result);
    }

    @Test
    public void twenty_returns_false() {
        Less20 less20 = new Less20();
        boolean result = less20.isLessThanMultipleOf20(20);
        Assert.assertFalse("20 incorrectly returned true", result);
    }

    @Test
    public void thirty_seven_returns_false() {
        Less20 less20 = new Less20();
        boolean result = less20.isLessThanMultipleOf20(37);
        Assert.assertFalse("37 incorrectly returned true", result);
    }

    @Test
    public void thirty_eight_returns_true() {
        Less20 less20 = new Less20();
        boolean result = less20.isLessThanMultipleOf20(38);
        Assert.assertTrue("38 incorrectly returned false", result);
    }

    @Test
    public void forty_returns_false() {
        Less20 less20 = new Less20();
        boolean result = less20.isLessThanMultipleOf20(40);
        Assert.assertFalse("40 incorrectly returned true", result);
    }

}
