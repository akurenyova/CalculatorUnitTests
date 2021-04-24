package com.epam.junit.tests;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SumDoubleCalculatorTest extends BaseTest {

    private double numA;
    private double numB;
    private double expectedValue;

    public SumDoubleCalculatorTest(double numA, double numB, double expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10.5, 12.3, 22.8},
                {0, 0, 0},
                {-10.25, 10, -0.25},
                {10.5, -5, 5.5}
        });
    }

    @Test
    public void aPlusBPositiveTest() {
        double result = calculator.sum(numA,numB);
        assertEquals(expectedValue, result, 0.01);
    }

}

