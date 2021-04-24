package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class IsNegativeCalculatorTest extends BaseTest {

    private long numA;

    public IsNegativeCalculatorTest(long numA) {
        this.numA = numA;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-10}
        });
    }

    @Test
    public void aNegativeTest() {
        boolean result = calculator.isNegative(numA);
        Assert.assertTrue(result, "Invalid result of IsPositive operation!");
    }

}
