package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SinCalculatorTest extends BaseTest {

    private double numA;
    private double expectedValue;

    public SinCalculatorTest(double numA, double expectedValue) {
        this.numA = numA;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Math.toRadians(90), 1},
                {Math.toRadians(270), -1}
        });
    }

    @Test
    public void aSinPositiveTest() {
        double result = calculator.sin(numA);
        assertEquals("Invalid result of sin operation!", expectedValue, result, 0.01);
    }

}
