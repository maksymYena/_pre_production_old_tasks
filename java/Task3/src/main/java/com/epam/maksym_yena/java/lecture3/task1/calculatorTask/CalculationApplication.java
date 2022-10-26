package com.epam.maksym_yena.java.lecture3.task1.calculatorTask;

import java.util.Scanner;

public class CalculationApplication {
    public static void main(String[] args) {
        CalculationApplication application = new CalculationApplication();
        application.initialization(application);
        }
    /*Initialization values (a,b) and initialization Scanner*/
    public void initialization(CalculationApplication application){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input first value :");
        int a = scanner.nextInt();
        System.out.println("Please, input second value :");
        int b = scanner.nextInt();
        System.out.print("Choose operation\n1.+\n2.-\n3./\n4.* : ");
        int choose = scanner.nextInt();
        isDisplayedMenu(choose,application,a,b);
    }
    /*
    Displayed menu and call the function of arifmetics operations */
   public void isDisplayedMenu(int choose, CalculationApplication application, int a, int b){
        switch (choose) {
            case 1:
                application.add(a, b);
                break;
            case 2:
                application.subtract(a, b);
                break;
            case 3:
                application.division(a, b);
                break;
            case 4:
                application.multiplication(a, b);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Please, try again!\nYour choose is uncorrect!");
                break;
        }
    }

    public void add(int a, int b){
        int result = a + b;
        System.out.println("Result of operation [add] = " + result);
    }

    public void subtract(int a, int b){
        int result = a - b;
        System.out.println("Result of operation [subtract] = " + result);
    }

    public void division(int a, int b) {
        if (b == 0) {
            System.out.println("Exception!\nDivision by zero! Try again!");
        } else {
            int result = a / b;
            System.out.println("Result of operation [division] = " + result);
        }
    }

    public void multiplication(int a, int b){
        int result = a * b;
        System.out.println("Result of operation [multiplication] = " + result);
    }

}
