package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CtgCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForCtgPositiveTest")
    public Object[][] valuesForCtgPositive() {
        return new Object[][] {
                {Math.toRadians(45), 1},
                {Math.toRadians(90), 0},
                {Math.toRadians(270), 0}
        };
    }

    @DataProvider(name = "valuesForCtgNegativeTest")
    public Object[][] valuesForCtgNegative() {
        return new Object[][] {
                {Math.toRadians(60), -1},
                {Math.toRadians(30), 0},
        };
    }

    @DataProvider(name = "valuesForCtgNotExistsNegativeTest")
    public Object[][] valuesForCtgNotExistsNegative() {
        return new Object[][] {
                {Math.toRadians(180), -1}
        };
    }

    @Test(dataProvider = "valuesForCtgPositiveTest", groups = {"positive", "trig"})
    public void aCtgPositiveTest(double numA, double expectedValue){
        double result = calculator.ctg(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of ctg operation for positive test!");
    }

    @Test (dataProvider = "valuesForCtgNegativeTest", groups = "trig", expectedExceptions = AssertionError.class)
    public void aCtgNegativeTest(double numA, double expectedValue){
        double result = calculator.ctg(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of ctg operation for negative test!");
    }

    @Test (dataProvider = "valuesForCtgNotExistsNegativeTest", groups = "trig",
            expectedExceptions = NumberFormatException.class)
    public void aCtgNotExistsNegativeTest(double numA, double expectedValue){
        double result = calculator.ctg(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of ctg operation for negative test!");
    }

}

