package com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations;

import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DifTest {

    private Operation operation;

    @Before
    public void setUp () {
        operation = new Dif();
    }

    @Test
    public void resultDif() {
        int actualResult = operation.calculate(10,10);
        double expectedResult = 10 - 10;
        assertEquals(expectedResult,actualResult, 0.00001);
    }

    @Test
    public void checkNegativeDif() {
        int actual = operation.calculate(-10,-20);
        int expected = (-10) - (-20);
        assertEquals(expected,actual);
    }

    @After
    public void tearDown() {
        operation = null;
    }
}