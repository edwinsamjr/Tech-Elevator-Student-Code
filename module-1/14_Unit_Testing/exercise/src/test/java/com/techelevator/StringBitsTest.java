package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    @Test
    public void tests_hello() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("hello");
        Assert.assertEquals("The method does not return the expected string", "hlo", result);
    }

    @Test
    public void tests_hi() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("Hi");
        Assert.assertEquals("The method does not return the expected string", "H", result);
    }

    @Test
    public void tests_heeololeo() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("heeololeo");
        Assert.assertEquals("The method does not return the expected string", "hello", result);
    }

    @Test
    public void tests_null_string() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits(null);
        Assert.assertEquals("The method does not return the expected string", "", result);
    }

    @Test
    public void tests_empty_string() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("");
        Assert.assertEquals("The method does not return the expected string", "", result);
    }

    @Test
    public void tests_string_with_characters() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("&F*O/N");
        Assert.assertEquals("The method does not return the expected string", "&*/", result);
    }

}
