package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class CosCalculatorTest extends BaseTest {

    private double numA;
    private double expectedValue;

    public CosCalculatorTest(double numA, double expectedValue) {
        this.numA = numA;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Math.toRadians(90), 0},
                {Math.toRadians(180), -1},
                {Math.toRadians(270), 0}
        });
    }

    @Test
    public void aCosPositiveTest() {
        double result = calculator.cos(numA);
        assertEquals("Invalid result of cos operation!", expectedValue, result, 0.01);
    }

}
