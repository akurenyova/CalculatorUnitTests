package com.epam.testng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class IsNegativeCalculatorTest extends BaseTest {

    @DataProvider(name = "valuesForIsNegativePositiveTest")
    public Object[][] valuesForIsNegativePositive() {
        return new Object[][] {
                {-10}
        };
    }

    @DataProvider(name = "valuesForIsNegativeNegativeTest")
    public Object[][] valuesForIsNegativeNegative() {
        return new Object[][] {
                {5},
                {0}
        };
    }

    @Test(dataProvider = "valuesForIsNegativePositiveTest", groups = "positive")
    public void aIsNegativePositiveTest(long numA){
        boolean result = calculator.isNegative(numA);
        Assert.assertTrue(result, "Invalid result of IsNegative operation for positive test!");
    }

    @Test (dataProvider = "valuesForIsNegativeNegativeTest")
    public void aIsNegativeNegativeTest(long numA){
        boolean result = calculator.isNegative(numA);
        Assert.assertFalse(result, "Invalid result of IsNegative operation for negative test!");
    }

}

