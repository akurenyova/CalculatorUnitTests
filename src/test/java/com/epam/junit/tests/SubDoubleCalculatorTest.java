package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class SubDoubleCalculatorTest extends BaseTest {

    private double numA;
    private double numB;
    private double expectedValue;

    public SubDoubleCalculatorTest(double numA, double numB, double expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {12.2, 10.2, 2},
                {0, 0, 0},
                {-10.25, 10, -20.25},
                {5.75, 5.25, 0.5}
        });
    }

    @Test
    public void aMinusBPositiveTest(){
        double result = calculator.sub(numA,numB);
        assertEquals("Invalid result of sub operation!", expectedValue, result, 0.01);
    }

}
