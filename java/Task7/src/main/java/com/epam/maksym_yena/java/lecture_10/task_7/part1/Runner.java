package com.epam.maksym_yena.java.lecture_10.task_7.part1;

import com.epam.maksym_yena.java.lecture_10.task_7.part1.Operations.Dif;
import com.epam.maksym_yena.java.lecture_10.task_7.part1.Operations.Div;
import com.epam.maksym_yena.java.lecture_10.task_7.part1.Operations.Mult;
import com.epam.maksym_yena.java.lecture_10.task_7.part1.Operations.Sum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Operation OPERATION = null;

    public static void main(String[] args)  {
        String chooce = "";
        Runner run;
            String logTemp;
            LOGGER.info("Input lvl of log4j\n1.Debug\n2.Info\n3.Warm\n4.Error\n5.All\n0.Exit: ");
            logTemp = SCANNER.next();
            switch (logTemp) {
                case "Debug":
                    chooce = "Debug";
                    run = new Runner();
                    run.initialization(chooce);
                    break;
                case "Info":
                    chooce = "Info";
                    run = new Runner();
                    run.initialization(chooce);
                    break;
                case "Warm":
                    chooce = "Warm";
                    run = new Runner();
                    run.initialization(chooce);
                    break;
                case "Error":
                    chooce = "Error";
                    run = new Runner();
                    run.initialization(chooce);
                    break;
                case "All":
                    chooce = "All";
                    run = new Runner();
                    run.initialization(chooce);
                    break;
                case "Exit":
                    System.exit(0);
                default:
                    LOGGER.error("Try again!");
                    break;
            }
    }

    public void initialization(String chooce) {
        LOGGER.info("Please, input first value : ");
        int a = SCANNER.nextInt();
        LOGGER.info("Please, input second value: ");
        int b = SCANNER.nextInt();
        if((chooce.equals("Info")) || (chooce.equals("All"))) {
            LOGGER.info("INPUT FIRST VALUE" + a);
            LOGGER.info("INPUT second VALUE" + b);
        }
        isDisplayedMenu(a, b, OPERATION, chooce);
    }

    public void isDisplayedMenu(int a, int b, Operation operation, String chooce) {
        String choose;
        do {
            LOGGER.info("Input operation [0 - Exit] : ");
            choose = SCANNER.next();
            switch (choose) {
                case "+":
                    operation = new Sum();
                    if(chooce.equals("Debug") || chooce.equals("All")) {
                        LOGGER.debug("Creating new object SUM()");
                    }
                    operation.calculate(a, b);
                    break;
                case "/":
                    operation = new Div();
                    if(chooce.equals("Warm")|| chooce.equals("All")) {
                        LOGGER.warn("Here can be division by zero!");
                    }

                    if(chooce.equals("Debug")|| chooce.equals("All")) {
                        LOGGER.debug("Creating new object div()");
                    }
                    operation.calculate(a, b);
                    break;
                case "*":
                    operation = new Mult();
                    if(chooce.equals("Debug")|| chooce.equals("All")) {
                        LOGGER.debug("Creating new object mult()");
                    }
                    operation.calculate(a, b);
                    break;
                case "-":
                    operation = new Dif();
                    if(chooce.equals("Debug")|| chooce.equals("All")) {
                        LOGGER.debug("Creating new object dif()");
                    }
                    operation.calculate(a, b);
                    break;
                case "0":
                    System.out.println("Exit..");
                    break;
                default:
                    if(chooce.equals("Error")|| chooce.equals("All")) {
                        LOGGER.error("Unknown name of command");
                    }
                    LOGGER.error("Please, try again!\nYour choose is incorrect!");
                    break;
            }
        } while (!choose.equals("0"));
    }
}
