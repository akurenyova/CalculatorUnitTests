package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivLongCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForDivPositiveTest")
    public Object[][] valuesForDivPositive() {
        return new Object[][]{
                {4, 2, 2},
                {7, 2, 3},
                {-10, 2, -5},
                {-10, -5, 2},
                {0, 5, 0},
        };
    }

    @DataProvider(name = "valuesForDivNegativeTest")
    public Object[][] valuesForDivNegative() {
        return new Object[][]{
                {7, 2, 4},
                {0, 5, 5},
                {-10, 10, 1},
                {-10, -5, -2}
        };
    }

    @DataProvider(name = "valuesForDivZeroNegativeTest")
    public Object[][] valuesForDivZeroNegative() {
        return new Object[][]{
                {0, 0, 0},
                {5, 0, 5}
        };
    }

    @Test(dataProvider = "valuesForDivPositiveTest", groups = "positive")
    public void aDivBPositiveTest(long numA, long numB, long expectedValue){
        long result = calculator.div(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long div operation for positive test!");
    }

    @Test (dataProvider = "valuesForDivNegativeTest",
            expectedExceptions = AssertionError.class)
    public void aDivBNegativeTest(long numA, long numB, long expectedValue){
        long result = calculator.div(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long div operation for negative test!");
    }

    @Test (dataProvider = "valuesForDivZeroNegativeTest",
            expectedExceptions = NumberFormatException.class)
    public void aDivZeroNegativeTest(long numA, long numB, long expectedValue){
        long result = calculator.div(numA, numB);
        Assert.assertEquals(result, expectedValue,
                "Invalid result of long div operation for negative test!");
    }

}