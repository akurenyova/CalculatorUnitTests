package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultLongCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForMultPositiveTest")
    public Object[][] valuesForMultPositive() {
        return new Object[][]{
                {2, 3, 6},
                {0, 0, 0},
                {-10, 10, -100},
                {-10, -5, 50},
                {5, 0, 0},
        };
    }

    @DataProvider(name = "valuesForMultNegativeTest")
    public Object[][] valuesForMultNegative() {
        return new Object[][]{
                {10, 12, -120},
                {0, 0, -1},
                {-10, 10, 100},
                {5, 0, 5}
        };
    }

    @Test(dataProvider = "valuesForMultPositiveTest", groups = "positive")
    public void aMultBPositiveTest(long numA, long numB, long expectedValue){
        long result = calculator.mult(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long mult operation for positive test!");
    }

    @Test (dataProvider = "valuesForMultNegativeTest", expectedExceptions = AssertionError.class)
    public void aMultBNegativeTest(long numA, long numB, long expectedValue){
        long result = calculator.mult(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long mult operation for negative test!");
    }

}