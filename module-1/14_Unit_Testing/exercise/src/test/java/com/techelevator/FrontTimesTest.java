package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    @Test
    public void chocolate_2_returns_chocho() {
        FrontTimes frontTimes = new FrontTimes();
        String resultString = frontTimes.generateString("Chocolate", 2);
        Assert.assertEquals("An incorrect string was returned", "ChoCho", resultString);
    }

    @Test
    public void chocolate_3_returns_chochocho() {
        FrontTimes frontTimes = new FrontTimes();
        String resultString = frontTimes.generateString("Chocolate", 3);
        Assert.assertEquals("An incorrect string was returned", "ChoChoCho", resultString);
    }

    @Test
    public void abc_3_returns_abcabcabc() {
        FrontTimes frontTimes = new FrontTimes();
        String resultString = frontTimes.generateString("Abc", 3);
        Assert.assertEquals("An incorrect string was returned", "AbcAbcAbc", resultString);
    }

    @Test
    public void chocolate_0_returns_empty_string() {
        FrontTimes frontTimes = new FrontTimes();
        String resultString = frontTimes.generateString("Chocolate", 0);
        Assert.assertEquals("An incorrect string was returned", "", resultString);
    }

    @Test
    public void null_string_returns_empty_string() {
        FrontTimes frontTimes = new FrontTimes();
        String resultString = frontTimes.generateString(null, 3);
        Assert.assertEquals("An incorrect result was returned", "", resultString);
    }

    @Test
    public void ab_4_returns_abababab() {
        FrontTimes frontTimes = new FrontTimes();
        String resultString = frontTimes.generateString("Ab", 4);
        Assert.assertEquals("An incorrect result was returned", "AbAbAbAb", resultString);
    }

}
