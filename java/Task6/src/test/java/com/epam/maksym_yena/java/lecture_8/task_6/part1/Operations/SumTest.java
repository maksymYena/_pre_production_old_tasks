package com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations;

import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {
    private Operation operation;

    @Before
    public void setUp() throws Exception {
        operation = new Sum();
    }

    @Test
    public void negativeSum() {
        int actualResult = operation.calculate(-10,-10);
        int expectedResult = (-10) + (-10);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void positiveSum() {
        int actualResult = operation.calculate(10,10);
        int expectetResult = 10 + 10;
        assertEquals(expectetResult, actualResult);
    }

    @After
    public void tearDown() throws Exception {
        operation = null;
    }
}