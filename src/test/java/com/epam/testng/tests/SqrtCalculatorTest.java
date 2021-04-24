package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SqrtCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForSqrtPositiveTest")
    public Object[][] valuesForSqrtPositive() {
        return new Object[][]{
                {4, 2},
                {0, 0},
                {1, 1}
        };
    }

    @DataProvider(name = "valuesForSqrtNegativeTest")
    public Object[][] valuesForSqrtNegative() {
        return new Object[][]{
                {8, 4},
                {4, 0}
        };
    }

    @DataProvider(name = "valuesForSqrtNegativeValueNegativeTest")
    public Object[][] valuesForSqrtNegativeValueNegative() {
        return new Object[][]{
                {-8, 4},
                {-4, 0}
        };
    }

    @Test(dataProvider = "valuesForSqrtPositiveTest", groups = "positive")
    public void aSqrtPositiveTest(double numA, double expectedValue){
        double result = calculator.sqrt(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of sqrt operation for positive test!");
    }

    @Test (dataProvider = "valuesForSqrtNegativeTest", expectedExceptions = AssertionError.class)
    public void aSqrtNegativeTest(double numA, double expectedValue){
        double result = calculator.sqrt(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of sqrt operation for negative test!");
    }

    @Test (dataProvider = "valuesForSqrtNegativeValueNegativeTest", expectedExceptions = NumberFormatException.class)
    public void aSqrtNegativeValueNegativeTest(double numA, double expectedValue){
        double result = calculator.sqrt(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of sqrt operation for negative test!");
    }

}

