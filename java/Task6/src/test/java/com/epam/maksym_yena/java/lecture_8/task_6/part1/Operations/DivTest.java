package com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations;

import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivTest {
    private Operation operation;
    @Before
    public void setUp() throws Exception {
        operation = new Div();
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
       double result = operation.calculate(10,0);
    }

    @Test
    public void divisionValues() {
        double actualResult = operation.calculate(10,1);
        double  expected = 10;
        assertEquals(expected, actualResult,0.0001);
    }

    @After
    public void tearDown() throws Exception {
        operation = null;
    }
}