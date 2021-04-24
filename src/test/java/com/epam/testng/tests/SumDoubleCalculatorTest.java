package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumDoubleCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForSumPositiveTest")
    public Object[][] valuesForSumPositive() {
        return new Object[][]{
                {10.5, 12.3, 22.8},
                {0, 0, 0},
                {-10.25, 10, -0.25},
                {10.5, -5, 5.5}
        };
    }

    @DataProvider(name = "valuesForSumNegativeTest")
    public Object[][] valuesForSumNegative() {
        return new Object[][]{
                {10.5, 12.3, 22},
                {0, 0, -1}
        };
    }

     @Test(dataProvider = "valuesForSumPositiveTest", groups = "positive")
    public void aPlusBPositiveTest(double numA, double numB, double expectedValue){
        double result = calculator.sum(numA,numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of double sum operation for positive test!");
    }

    @Test(dataProvider = "valuesForSumNegativeTest", expectedExceptions = AssertionError.class)
    public void aPlusBNegativeTest(double numA, double numB, double expectedValue){
        double result = calculator.sum(numA,numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of double sum operation for negative test!");
    }

}
