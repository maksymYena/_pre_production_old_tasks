package com.epam.maksym_yena.java.lecture3.task1.stringTask;

import java.util.Arrays;
import java.util.Scanner;

public class StringApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Input count of strings: ");
        n = sc.nextInt();

        String[] str = new String[n];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Input  №" + (i + 1) + " word");
            str[i] = sc.next();
        }
        int counter = 0;
        int[] countCheck = new int[str.length];
        for(int i = 0; i < countCheck.length; i++) {
            countCheck[i] = 0;
        }
        if(str.length < 2){
            System.out.println(str[0]);
        }
        else {
            for (int i = 0; i < str.length; i++) {
                char[] toChar = str[i].toCharArray();
                counter = 0;
                for (int j = 0; j < toChar.length; j++) {
                    char tmp = toChar[j];
                    for (int k = j + 1; k < toChar.length; k++) {
                        if (tmp == toChar[k]) {
                            counter++;
                            countCheck[i] = counter;
                            break;
                        }
                    }
                }
            }
        }
        int maxIndex = countCheck[0];
        for(int i=0; i< countCheck.length;i++) {
            if (maxIndex < countCheck[i]) {
                maxIndex = i;
            }
        }

        System.out.println("The count of different symbols is minimum in this word: " + str[maxIndex]);
    }
}
