package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class IsPositiveCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForIsPositivePositiveTest")
    public Object[][] valuesForIsPositivePositive() {
        return new Object[][] {
                {10}
        };
    }

    @DataProvider(name = "valuesForIsPositiveNegativeTest")
    public Object[][] valuesForIsPositiveNegative() {
        return new Object[][] {
                {-5},
                {0},
        };
    }

    @Test(dataProvider = "valuesForIsPositivePositiveTest", groups = "positive")
    public void aIsPositivePositiveTest(long numA){
        boolean result = calculator.isPositive(numA);
        Assert.assertTrue(result, "Invalid result of IsPositive operation for positive test!");
    }

    @Test (dataProvider = "valuesForIsPositiveNegativeTest")
    public void aIsPositiveNegativeTest(long numA){
        boolean result = calculator.isPositive(numA);
        Assert.assertFalse(result, "Invalid result of IsPositive operation for negative test!");
    }

}

