package com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations;

import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operation;

public class Div extends Operation {
    @Override
    public int calculate(int a, int b) {
        int result = a / b;
        return result;
        }
}
