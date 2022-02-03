package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    @Test
    public void yes_if_you_equals_8_and_date_equals_3() {
        DateFashion couple = new DateFashion();
        int tableScore = couple.getATable(8, 3);
        Assert.assertEquals("The couple was given an incorrect response", 2, tableScore);
    }

    @Test
    public void no_if_you_equals_8_and_date_equals_3() {
        DateFashion couple = new DateFashion();
        int tableScore = couple.getATable(8, 2);
        Assert.assertEquals("The couple was given an incorrect response", 0, tableScore);
    }

    @Test
    public void maybe_if_you_equals_7_and_date_equals_3() {
        DateFashion couple = new DateFashion();
        int tableScore = couple.getATable(7, 3);
        Assert.assertEquals("The couple was given an incorrect response", 1, tableScore);
    }

    @Test
    public void no_if_you_equals_negative_1_and_date_equals_10() {
        DateFashion couple = new DateFashion();
        int tableScore = couple.getATable(-1, 10);
        Assert.assertEquals("The couple was given an incorrect response", 0, tableScore);
    }

    @Test
    public void no_if_you_equals_7_and_date_equals_2() {
        DateFashion couple = new DateFashion();
        int tableScore = couple.getATable(7, 2);
        Assert.assertEquals("The couple was given an incorrect response", 0, tableScore);
    }

}
