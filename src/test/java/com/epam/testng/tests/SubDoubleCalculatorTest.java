package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubDoubleCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForSubPositiveTest")
    public Object[][] valuesForSubPositive() {
        return new Object[][]{
                {12.2, 10.2, 2},
                {0, 0, 0},
                {-10.25, 10, -20.25},
                {5.75, 5.25, 0.5}
        };
    }

    @DataProvider(name = "valuesForSubNegativeTest")
    public Object[][] valuesForSubNegative() {
        return new Object[][]{
                {12.5, 10.3, 2},
                {0, 0, -1},
        };
    }

    @Test(dataProvider = "valuesForSubPositiveTest", groups = "positive")
    public void aMinusBPositiveTest(double numA, double numB, double expectedValue){
        double result = calculator.sub(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long sub operation for positive test!");
    }

    @Test (dataProvider = "valuesForSubNegativeTest", expectedExceptions = AssertionError.class)
    public void aMinusBNegativeTest(double numA, double numB, double expectedValue){
        double result = calculator.sub(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long sub operation for negative test!");
    }

}

