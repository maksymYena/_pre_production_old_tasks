package com.epam.java.maksym_yena.lecture_10.task_8.part_1;

import java.io.IOException;
import java.util.Scanner;

public class Runner {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Calculate CALCULATE = new Calculate();

    public static void main(String[] args) throws IOException {

        CALCULATE.menu();
    }
}
