package com.epam.maksym_yena.java.lecture_10.task_7.part1.Operations;

import com.epam.maksym_yena.java.lecture_10.task_7.part1.Operation;

public class Div extends Operation {
    @Override
    public int calculate(int a, int b) {
        int result = a / b;
        System.out.println("Result of operation : " + result);
        return result;
        }
}
