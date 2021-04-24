package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DivDoubleCalculatorTest extends BaseTest {

    private double numA;
    private double numB;
    private double expectedValue;

    public DivDoubleCalculatorTest(double numA, double numB, double expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4.2, 2, 2.1},
                {15.2, 3.8, 4},
                {-10.4, 2, -5.2},
                {-10.5, -5, 2.1},
                {0, 5.2, 0},
        });
    }

    @Test
    public void aDivBPositiveTest() {
        double result = calculator.div(numA,numB);
        assertEquals("Invalid result of div operation!", expectedValue, result, 0.01);
    }

}
