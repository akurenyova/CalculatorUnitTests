package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultDoubleCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForMultPositiveTest")
    public Object[][] valuesForMultPositive() {
        return new Object[][]{
                {2.2, 3.3, 7.26},
                {0, 0, 0},
                {-10.525, 10, -105.25},
                {-10, -5.53, 55.3},
                {5.25, 0, 0},
        };
    }

    @DataProvider(name = "valuesForMultNegativeTest")
    public Object[][] valuesForMultNegative() {
        return new Object[][]{
                {10, 12.2, -120},
                {0.1, 0, -1},
                {-10.52, 10, 105.2}
        };
    }

    @Test(dataProvider = "valuesForMultPositiveTest", groups = "positive")
    public void aMultBPositiveTest(double numA, double numB, double expectedValue){
        double result = calculator.mult(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of double mult operation for positive test!");
    }

    @Test (dataProvider = "valuesForMultNegativeTest", expectedExceptions = AssertionError.class)
    public void aMultBNegativeTest(double numA, double numB, double expectedValue){
        double result = calculator.mult(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of double mult operation for negative test!");
    }

}

