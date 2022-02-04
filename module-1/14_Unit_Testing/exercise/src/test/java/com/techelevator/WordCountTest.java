package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {


    @Test
    public void array_four_multiletter_strings() {
        WordCount wordCount = new WordCount();
        String[] testArray = new String[] {"ba", "ba", "black", "sheep"};
        Map<String, Integer> result = wordCount.getCount(testArray);
        Map<String, Integer> correctOutputMap = new HashMap<>();
        correctOutputMap.put("ba", 2);
        correctOutputMap.put("black", 1);
        correctOutputMap.put("sheep", 1);
        Assert.assertEquals("The Map output did not match the expected Map result",correctOutputMap, result );
    }

    @Test
    public void array_of_five_single_letter_strings() {
        WordCount wordCount = new WordCount();
        String[] testArray = new String[] {"a", "b", "a", "c", "b"};
        Map<String, Integer> result = wordCount.getCount(testArray);
        Map<String, Integer> correctOutputMap = new HashMap<>();
        correctOutputMap.put("a", 2);
        correctOutputMap.put("b", 2);
        correctOutputMap.put("c", 1);
        Assert.assertEquals("The Map output did not match the expected Map result",correctOutputMap, result );
    }

    @Test
    public void empty_array() {
        WordCount wordCount = new WordCount();
        String[] testArray = new String[] {};
        Map<String, Integer> result = wordCount.getCount(testArray);
        Map<String, Integer> correctOutputMap = new HashMap<>();
        Assert.assertEquals("The Map output did not match the expected Map result",correctOutputMap, result );
    }

    @Test
    public void three_single_letter_strings() {
        WordCount wordCount = new WordCount();
        String[] testArray = new String[] {"c", "b", "a"};
        Map<String, Integer> result = wordCount.getCount(testArray);
        Map<String, Integer> correctOutputMap = new HashMap<>();
        correctOutputMap.put("c", 1);
        correctOutputMap.put("b", 1);
        correctOutputMap.put("a", 1);
        Assert.assertEquals("The Map output did not match the expected Map result",correctOutputMap, result );
    }

    @Test
    public void array_of_strings_of_numbers() {
        WordCount wordCount = new WordCount();
        String[] testArray = new String[] {"22", "22", "11"};
        Map<String, Integer> result = wordCount.getCount(testArray);
        Map<String, Integer> correctOutputMap = new HashMap<>();
        correctOutputMap.put("22", 2);
        correctOutputMap.put("11", 1);
        Assert.assertEquals("The Map output did not match the expected Map result",correctOutputMap, result );
    }

    @Test
    public void null_array() {
        WordCount wordCount = new WordCount();
        String[] testArray = null;
        Map<String, Integer> result = wordCount.getCount(testArray);
        Map<String, Integer> correctOutputMap = new HashMap<>();
        Assert.assertEquals("The Map output did not match the expected Map result",correctOutputMap, result );
    }

    @Test
    public void array_of_string_of_characters() {
        WordCount wordCount = new WordCount();
        String[] testArray = new String[] {"&&", "||", "&&"};
        Map<String, Integer> result = wordCount.getCount(testArray);
        Map<String, Integer> correctOutputMap = new HashMap<>();
        correctOutputMap.put("&&", 2);
        correctOutputMap.put("||", 1);
        Assert.assertEquals("The Map output did not match the expected Map result",correctOutputMap, result );
    }



}
