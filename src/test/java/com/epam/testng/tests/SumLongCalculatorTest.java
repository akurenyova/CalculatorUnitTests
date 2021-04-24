package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumLongCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForSumPositiveTest")
    public Object[][] valuesForSumPositive() {
        return new Object[][]{
                {10, 12, 22},
                {0, 0, 0},
                {-10, 10, 0},
                {10, -5, 5},
        };
    }

    @DataProvider(name = "valuesForSumNegativeTest")
    public Object[][] valuesForSumNegative() {
        return new Object[][]{
                {10, 12, 32},
                {0, 0, -1},
                {-10, 10, -10}
        };
    }

    @Test (dataProvider = "valuesForSumPositiveTest", groups = "positive")
    public void aPlusBPositiveTest(long numA, long numB, long expectedValue){
        long result = calculator.sum(numA,numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long sum operation for positive test!");
    }

    @Test (dataProvider = "valuesForSumNegativeTest", expectedExceptions = AssertionError.class)
    public void aPlusBNegativeTest(long numA, long numB, long expectedValue){
        long result = calculator.sum(numA,numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long sum operation for negative test!");
    }

}
