package com.epam.maksym_yena.test_automation.task8;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }


    @DataProvider(name = "dataForCalculate")
    public static Object[][] credentials() {
        return new Object[][]{
                {5, 5},
                {1, -1},
                {0, 5},
                {-1, -1}
        };
    }
    @Parameters( { "firstValue", "secondValue" , "sum" })
    @Test
    public void testSum(int firstValue, int secondValue, int sum) {

        Assert.assertEquals(calculator.sum(firstValue,secondValue), sum);
    }

    @Test(dataProvider = "dataForCalculate")
    public void testDivision(int firstValue, int secondValue) throws ArithmeticException {
        Assert.assertEquals(calculator.division(firstValue,secondValue),firstValue / secondValue);
    }

    @Parameters( { "firstValue", "secondValue" , "multiplication" })
    @Test
    public void testMult(int firstValue, int secondValue, int multiplication) {
        Assert.assertEquals(calculator.mult(firstValue,secondValue), multiplication);
    }

    @Parameters( { "firstValue", "secondValue" , "subtract" })
    @Test
    public void testSubtract(int firstValue, int secondValue, int subtract) {
        Assert.assertEquals(calculator.subtract(firstValue,secondValue), subtract);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}