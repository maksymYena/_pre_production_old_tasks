package com.epam.maksym_yena.java.lecture_8.task_6.part1;

import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations.Dif;
import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations.Div;
import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations.Mult;
import com.epam.maksym_yena.java.lecture_8.task_6.part1.Operations.Sum;

import java.util.Scanner;

public class Runner {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Operation OPERATION = null;

    public static void main(String[] args) {
        Runner run = new Runner();
        run.initialization();
    }

    public void initialization() {
        System.out.print("Please, input first value : ");
        int a = SCANNER.nextInt();
        System.out.print("Please, input second value : ");
        int b = SCANNER.nextInt();

        isDisplayedMenu(a, b, OPERATION);
    }

    public void isDisplayedMenu(int a, int b, Operation operation) {
        String choose;
        do {
            System.out.print("Input operation [0 - Exit] : ");
            choose = SCANNER.next();
            switch (choose) {
                case "+":
                    operation = new Sum();
                    operation.calculate(a, b);
                    break;
                case "/":
                    operation = new Div();
                    operation.calculate(a, b);
                    break;
                case "*":
                    operation = new Mult();
                    operation.calculate(a, b);
                    break;
                case "-":
                    operation = new Dif();
                    operation.calculate(a, b);
                    break;
                case "0":
                    System.out.println("Exit..");
                    break;
                default:
                    System.out.println("Please, try again!\nYour choose is incorrect!");
                    break;
            }
        } while (!choose.equals("0"));
    }
}
