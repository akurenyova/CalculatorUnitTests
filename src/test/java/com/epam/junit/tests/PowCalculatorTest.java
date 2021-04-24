package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class PowCalculatorTest extends BaseTest {

    private double numA;
    private double numB;
    private double expectedValue;

    public PowCalculatorTest(double numA, double numB, double expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 3, 8},
                {0, 0, 1},
                {5, 0, 1},
                {2, -1, 0.5}
        });
    }

    @Test
    public void aPowBPositiveTest() {
        double result = calculator.pow(numA,numB);
        assertEquals("Invalid result of pow operation!", expectedValue, result, 0.01);
    }

}
