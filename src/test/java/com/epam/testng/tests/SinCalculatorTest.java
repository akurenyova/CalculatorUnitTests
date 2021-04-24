package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SinCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForSinPositiveTest")
    public Object[][] valuesForSinPositive() {
        return new Object[][] {
                {Math.toRadians(90), 1},
                {Math.toRadians(270), -1}
        };
    }

    @DataProvider(name = "valuesForSinNegativeTest")
    public Object[][] valuesForSinNegative() {
        return new Object[][] {
                {60, -1},
                {30, 0},
        };
    }

    @Test(dataProvider = "valuesForSinPositiveTest", groups = {"positive", "trig"})
    public void aSinPositiveTest(double numA, double expectedValue){
        double result = calculator.sin(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of sin operation for positive test!");
    }

    @Test (dataProvider = "valuesForSinNegativeTest", groups = "trig", expectedExceptions = AssertionError.class)
    public void aSinNegativeTest(double numA, double expectedValue){
        double result = calculator.sin(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of sin operation for negative test!");
    }

}

