package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {

    @Test
    public void returns_herd_with_elephant_lowercase() {
        AnimalGroupName animalGroup = new AnimalGroupName();
        String testString = "elephant";
        String herdAnswer = animalGroup.getHerd(testString);
        Assert.assertEquals("The method does not return the expected value", "Herd", herdAnswer);

    }

    @Test
    public void returns_herd_with_elephant_mixed_cases() {
        AnimalGroupName animalGroup = new AnimalGroupName();
        String testString = "eLePhAnT";
        String herdAnswer = animalGroup.getHerd(testString);
        Assert.assertEquals("The method does not return the expected value", "Herd", herdAnswer);

    }

    @Test
    public void returns_unknown_with_string_not_in_animal_list() {
        AnimalGroupName animalGroup = new AnimalGroupName();
        String testString = "zebra";
        String herdAnswer = animalGroup.getHerd(testString);
        Assert.assertEquals("The method does not return the expected value", "unknown", herdAnswer);
    }

    @Test
    public void returns_unknown_with_empty_string() {
        AnimalGroupName animalGroup = new AnimalGroupName();
        String testString = "";
        String herdAnswer = animalGroup.getHerd(testString);
        Assert.assertEquals("The method does not return the expected value", "unknown", herdAnswer);
    }

    @Test
    public void returns_unknown_with_null_string() {
        AnimalGroupName animalGroup = new AnimalGroupName();
        String testString = null;
        String herdAnswer = animalGroup.getHerd(testString);
        Assert.assertEquals("The method does not return the expected value", "unknown", herdAnswer);
    }

}
