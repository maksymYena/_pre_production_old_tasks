package com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations;

import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultTest {

    private Operation operation;
    @Before
    public void setUp() throws Exception {
        operation = new Mult();
    }

    @Test
    public void checkMultOnZero() {
        long actualResult = operation.calculate(10,0);
        long expectedResut = 10 * 0;
        assertEquals(expectedResut,actualResult);
    }
    @Test
    public void resultMult() {
        long actualResult = operation.calculate(10,10);
        long expectedResult = 10 * 10;
        assertEquals(expectedResult,actualResult);
    }
    @After
    public void tearDown() throws Exception {
        operation = null;
    }
}