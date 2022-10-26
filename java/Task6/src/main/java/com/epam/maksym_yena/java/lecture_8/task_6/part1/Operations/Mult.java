package com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations;

import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operation;

public class Mult extends Operation {
    @Override
    public int calculate(int a, int b) {
        int result = a * b;
        System.out.println("Result of operation : " + result);
        return result;
    }
}
