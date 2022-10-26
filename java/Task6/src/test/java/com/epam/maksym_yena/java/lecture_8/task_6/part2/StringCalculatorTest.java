package com.epam.maksym_yena.java.lecture_8.task_6.part2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroWhenCalculateEmptyString() throws Exception {
        assertEquals(0,stringCalculator.add(""));
    }

    @Test
    public void shouldReturnTheSameOneArgs() throws Exception {
        assertEquals(1,stringCalculator.add("1"));
    }

    @Test
    public void shouldReturnSumOfTwoArg() throws Exception {
        assertEquals(6,stringCalculator.add("3,3"));
    }

    @Test
    public void shouldReturnSumOfUnknowCounValue() throws Exception {
        assertEquals(10, stringCalculator.add("1,2,3,3,1"));
    }

    @Test
    public void shouldReturnValueWithoudNewLineDelimeters() throws Exception {
        assertEquals(11, stringCalculator.add("6\n4,1"));
    }

    @Test(expected =  Exception.class, timeout = 30)
    public void shouldThrownExceptionWhenNegativeNumbersExist() throws Exception {
        stringCalculator.add("-5,1,-6,-7,-50");
    }

    @Test
    public void shouldBreakValueBiggestWhen_1000() throws Exception {
        assertEquals(2,stringCalculator.add("2,1001"));
    }

    @Test
    public void shouldReturnValueWithoutDelimeters() throws Exception {
        assertEquals(3,stringCalculator.add("//;\\n1;2"));
    }

    @Test
    public void shouldReturnValueIgnreMultypleDelimeters() throws Exception {
        assertEquals(6,stringCalculator.add("//[*][%]\\n1*2%3"));
    }

    @Test
    public void shouldReturnValueWithAnyLengthDelimeter() throws Exception {
        assertEquals(6,stringCalculator.add("//[***]\\n1***2***3"));
    }

    @After
    public void afterClass() throws Exception {
        stringCalculator = null;
    }
}
