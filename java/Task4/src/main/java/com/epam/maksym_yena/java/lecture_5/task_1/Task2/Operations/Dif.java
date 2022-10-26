package com.epam.maksym_yena.java.lecture_5.task_1.Task2.Operations;

import com.epam.maksym_yena.java.lecture_5.task_1.Task2.Operation;

 public class Dif extends Operation {
    @Override
    protected int calculate(int a, int b) {
        int result = a - b;
        System.out.println("Result of operation : " + result);
        return result;
    }
}
