package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    @Test
    public void tests_hello_and_there() {
        NonStart nonStart = new NonStart();
        String stringA = "Hello";
        String stringb = "There";
        String result = nonStart.getPartialString(stringA, stringb);
        Assert.assertEquals("The given string does not match the expected string", "ellohere", result);
    }

    @Test
    public void tests_shotl_and_java() {
        NonStart nonStart = new NonStart();
        String stringA = "shotl";
        String stringb = "java";
        String result = nonStart.getPartialString(stringA, stringb);
        Assert.assertEquals("The given string does not match the expected string", "hotlava", result);
    }

    @Test
    public void tests_single_letter_strings() {
        NonStart nonStart = new NonStart();
        String stringA = "A";
        String stringb = "B";
        String result = nonStart.getPartialString(stringA, stringb);
        Assert.assertEquals("The given string does not match the expected string", "", result);
    }

    @Test
    public void tests_null_strings() {
        NonStart nonStart = new NonStart();
        String stringA = null;
        String stringb = null;
        String result = nonStart.getPartialString(stringA, stringb);
        Assert.assertEquals("The given string does not match the expected string", "", result);
    }

    @Test
    public void tests_one_single_letter_string_and_one_multiletter_string() {
        NonStart nonStart = new NonStart();
        String stringA = "a";
        String stringb = "sbye";
        String result = nonStart.getPartialString(stringA, stringb);
        Assert.assertEquals("The given string does not match the expected string", "bye", result);
    }

}
