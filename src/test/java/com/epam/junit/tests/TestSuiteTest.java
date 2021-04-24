package com.epam.junit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SubLongCalculatorTest.class,
        SumLongCalculatorTest.class
}
)

public class TestSuiteTest {

}
