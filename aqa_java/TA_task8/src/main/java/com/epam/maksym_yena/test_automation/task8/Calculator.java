package com.epam.maksym_yena.test_automation.task8;

public class Calculator {

    public int sum(int a, int b) {
        return a+b;
    }

    public int division(int a, int b) throws ArithmeticException {
        int result = 0;
        try {
            if(b == 0 ) {
                throw new ArithmeticException();
            }
            else {
                result =  a / b;
            }
        }
        catch (ArithmeticException ex) {
            ex.getMessage();
        }
        return result;
    }

    public int mult(int a, int b) {
        return a * b;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

}
