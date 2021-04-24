package com.epam.junit.tests;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SumLongCalculatorTest extends BaseTest {

    private long numA;
    private long numB;
    private long expectedValue;

    public SumLongCalculatorTest(long numA, long numB, long expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 12, 22},
                {0, 0, 0},
                {-10, 10, 0},
                {10, -5, 5},
        });
    }

    @Test
    public void aPlusBPositiveTest() {
        long result = calculator.sum(numA,numB);
        assertEquals("Invalid result of sum operation!", expectedValue, result);
    }

}

