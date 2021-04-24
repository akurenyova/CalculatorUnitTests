package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class MultLongCalculatorTest extends BaseTest {

    private long numA;
    private long numB;
    private long expectedValue;

    public MultLongCalculatorTest(long numA, long numB, long expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 3, 6},
                {0, 0, 0},
                {-10, 10, -100},
                {-10, -5, 50},
                {5, 0, 0},
        });
    }

    @Test
    public void aDivBPositiveTest() {
        long result = calculator.mult(numA,numB);
        assertEquals("Invalid result of mult operation!", expectedValue, result);
    }

}
