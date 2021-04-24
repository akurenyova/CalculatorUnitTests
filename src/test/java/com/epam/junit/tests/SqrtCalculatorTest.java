package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SqrtCalculatorTest extends BaseTest {

    private double numA;
    private double expectedValue;

    public SqrtCalculatorTest(double numA, double expectedValue) {
        this.numA = numA;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, 2},
                {0, 0},
                {1, 1}
        });
    }

    @Test
    public void aPowBPositiveTest() {
        double result = calculator.sqrt(numA);
        assertEquals("Invalid result of sqrt operation!", expectedValue, result, 0.01);
    }

}
