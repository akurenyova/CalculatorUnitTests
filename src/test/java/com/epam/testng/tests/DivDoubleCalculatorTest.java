package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivDoubleCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForDivPositiveTest")
    public Object[][] valuesForDivPositive() {
        return new Object[][]{
                {4.2, 2, 2.1},
                {15.2, 3.8, 4},
                {-10.4, 2, -5.2},
                {-10.5, -5, 2.1},
                {0, 5.2, 0},
        };
    }

    @DataProvider(name = "valuesForDivNegativeTest")
    public Object[][] valuesForDivNegative() {
        return new Object[][]{
                {7, 2, 4},
                {0, 5.2, 5.2},
                {-10.5, 10.5, 1},
                {-10.5, -5, -2.1}
        };
    }

    @DataProvider(name = "valuesForDivZeroNegativeTest")
    public Object[][] valuesForDivZeroNegative() {
        return new Object[][]{
                {5.25, 0, 0},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "valuesForDivPositiveTest", groups = "positive")
    public void aDivBPositiveTest(double numA, double numB, double expectedValue){
        double result = calculator.div(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of double div operation for positive test!");
    }

    @Test (dataProvider = "valuesForDivNegativeTest",
            expectedExceptions = AssertionError.class)
    public void aDivBNegativeTest(double numA, double numB, double expectedValue){
        double result = calculator.div(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of double div operation for negative test!");
    }

    @Test (dataProvider = "valuesForDivZeroNegativeTest",
            expectedExceptions = NumberFormatException.class)
    public void aDivZeroNegativeTest(double numA, double numB, double expectedValue){
        double result = calculator.div(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of double div operation for negative test!");
    }

}