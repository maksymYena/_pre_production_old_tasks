package com.epam.maksym_yena.java.lecture_5.task_1.Task2.Operations;

import com.epam.maksym_yena.java.lecture_5.task_1.Task2.Operation;

public class Div extends Operation {
    @Override
    protected int calculate(int a, int b) {
        int result = 0;
        if (b == 0) {
            System.out.println("Division by zero!");
            return 0;
        } else {
            result = a / b;
            System.out.println("Result of operation : " + result);
            return result;
        }
    }
}
