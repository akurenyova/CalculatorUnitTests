package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class MultDoubleCalculatorTest extends BaseTest {

    private double numA;
    private double numB;
    private double expectedValue;

    public MultDoubleCalculatorTest(double numA, double numB, double expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2.2, 3.3, 7.26},
                {0, 0, 0},
                {-10.525, 10, -105.25},
                {-10, -5.53, 55.3},
                {5.25, 0, 0},
        });
    }

    @Test
    public void aDivBPositiveTest() {
        double result = calculator.mult(numA,numB);
        assertEquals("Invalid result of mult operation!", expectedValue, result, 0.01);
    }

}
