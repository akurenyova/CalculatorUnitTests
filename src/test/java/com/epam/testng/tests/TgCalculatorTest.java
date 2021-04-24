package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TgCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForTgPositiveTest")
    public Object[][] valuesForTgPositive() {
        return new Object[][] {
                {Math.toRadians(45), 1},
                {Math.toRadians(180), 0}
        };
    }

    @DataProvider(name = "valuesForTgNegativeTest")
    public Object[][] valuesForTgNegative() {
        return new Object[][] {
                {Math.toRadians(60), -1},
                {Math.toRadians(30), 0},
        };
    }

    @DataProvider(name = "valuesForTgNotExistsNegativeTest")
    public Object[][] valuesForTgNotExistsNegative() {
        return new Object[][] {
                {Math.toRadians(270), -1},
                {Math.toRadians(90), 0}
        };
    }

    @Test(dataProvider = "valuesForTgPositiveTest", groups = {"positive", "trig"})
    public void aTgPositiveTest(double numA, double expectedValue){
        double result = calculator.tg(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of tg operation for positive test!");
    }

    @Test (dataProvider = "valuesForTgNegativeTest", groups = "trig", expectedExceptions = AssertionError.class)
    public void aTgNegativeTest(double numA, double expectedValue){
        double result = calculator.tg(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of tg operation for negative test!");
    }

    @Test (dataProvider = "valuesForTgNotExistsNegativeTest", groups = "trig",
            expectedExceptions = NumberFormatException.class)
    public void aTgNotExistsNegativeTest(double numA, double expectedValue){
        double result = calculator.tg(numA);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of tg operation for negative test!");
    }

}

