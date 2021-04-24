package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DivLongCalculatorTest extends BaseTest {

    private long numA;
    private long numB;
    private long expectedValue;

    public DivLongCalculatorTest(long numA, long numB, long expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, 2, 2},
                {7, 2, 3},
                {-10, 2, -5},
                {-10, -5, 2},
                {0, 5, 0},
        });
    }

    @Test
    public void aDivBPositiveTest() {
        long result = calculator.div(numA,numB);
        assertEquals("Invalid result of div operation!", expectedValue, result);
    }

}
