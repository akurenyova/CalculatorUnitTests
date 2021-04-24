package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubLongCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForSubPositiveTest")
    public Object[][] valuesForSubPositive() {
        return new Object[][]{
                {12, 10, 2},
                {0, 0, 0},
                {-10, 10, -20},
                {5, 5, 0},
        };
    }

    @DataProvider(name = "valuesForSubNegativeTest")
    public Object[][] valuesForSubNegative() {
        return new Object[][]{
                {10, 12, 32},
                {0, 0, -1},
                {-10, 10, -10}
        };
    }

    @Test (dataProvider = "valuesForSubPositiveTest", groups = "positive")
    public void aMinusBPositiveTest(long numA, long numB, long expectedValue){
        long result = calculator.sub(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long sub operation for positive test!");
    }

    @Test (dataProvider = "valuesForSubNegativeTest", expectedExceptions = AssertionError.class)
    public void aMinusBNegativeTest(long numA, long numB, long expectedValue){
        long result = calculator.sub(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long sub operation for negative test!");
    }

}
