package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PowCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForPowPositiveTest")
    public Object[][] valuesForPowPositive() {
        return new Object[][]{
                {2, 3, 8},
                {0, 0, 1},
                {5, 0, 1},
                {2, -1, 0.5}
        };
    }

    @DataProvider(name = "valuesForPowNegativeTest")
    public Object[][] valuesForPowNegative() {
        return new Object[][]{
                {5, 2, 10},
                {0, 0, -1},
                {2, -1, -2}
        };
    }

    @Test(dataProvider = "valuesForPowPositiveTest", groups = "positive")
    public void aPowBPositiveTest(double numA, double numB, double expectedValue){
        double result = calculator.pow(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of pow operation for positive test!");
    }

    @Test (dataProvider = "valuesForPowNegativeTest", expectedExceptions = AssertionError.class)
    public void aPowBNegativeTest(double numA, double numB, double expectedValue){
        double result = calculator.sub(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of pow operation for negative test!");
    }

}

