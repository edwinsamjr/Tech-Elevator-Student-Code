package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void correct_value_returned_from_three_element_array() {
        // Arrange
        int[] arguments = new int[] { 1, 2, 3};

        // Act
        int actual = ArrayUtils.max(arguments);

        // Assert
        Assert.assertEquals("Didn't get expected max value", 3, actual);
    }

    @Test
    public void correct_value_returned_with_repeated_max_values() {
        // Arrange
        int[] arguments = new int[] { 3, 1, 2, 3};

        // Act
        int actual = ArrayUtils.max(arguments);

        // Assert
        Assert.assertEquals("Didn't get expected max value", 3, actual);
    }

    @Test
    public void correct_value_returned_with_all_negative_numbers() {
        // Arrange
        int[] arguments = new int[] { -3, -1, -2, -3};

        // Act
        int actual = ArrayUtils.max(arguments);

        // Assert
        Assert.assertEquals("Didn't get expected max value", -1, actual);
    }

    @Test
    public void correct_value_returned_with_empty_array() {
        // Arrange
        int[] arguments = new int[] { };

        // Act
        int actual = ArrayUtils.max(arguments);

        // Assert
        Assert.assertEquals("Didn't get expected max value", Integer.MIN_VALUE, actual);
    }

    @Test
    public void correct_value_returned_with_null_array() {
        // Arrange - Not needed

        // Act
        int actual = ArrayUtils.max(null);

        // Assert
        Assert.assertEquals("Didn't get expected max value", Integer.MIN_VALUE, actual);
    }
}
