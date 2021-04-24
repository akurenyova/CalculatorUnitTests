package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CosCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForCosPositiveTest")
    public Object[][] valuesForCosPositive() {
        return new Object[][] {
                {Math.toRadians(90), 0},
                {Math.toRadians(180), -1},
                {Math.toRadians(270), 0}
        };
    }

    @DataProvider(name = "valuesForCosNegativeTest")
    public Object[][] valuesForCosNegative() {
        return new Object[][] {
                {60, -1},
                {30, 0},
        };
    }

    @Test(dataProvider = "valuesForCosPositiveTest", groups = {"positive", "trig"})
    public void aCosPositiveTest(double numA, double expectedValue){
        double result = calculator.cos(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of cos operation for positive test!");
    }

    @Test (dataProvider = "valuesForCosNegativeTest", groups = "trig", expectedExceptions = AssertionError.class)
    public void aCosNegativeTest(double numA, double expectedValue){
        double result = calculator.cos(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of cos operation for negative test!");
    }

}

