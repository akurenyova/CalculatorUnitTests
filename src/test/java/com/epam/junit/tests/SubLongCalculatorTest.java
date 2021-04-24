package com.epam.junit.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class SubLongCalculatorTest extends BaseTest {

    private long numA;
    private long numB;
    private long expectedValue;

    public SubLongCalculatorTest(long numA, long numB, long expectedValue) {
        this.numA = numA;
        this.numB = numB;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {12, 10, 2},
                {0, 0, 0},
                {-10, 10, -20},
                {5, 5, 0},
        });
    }

    @Test
    public void aMinusBPositiveTest(){
        long result = calculator.sub(numA,numB);
        assertEquals("Invalid result of sub operation!", expectedValue, result);
    }

}
