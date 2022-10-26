package com.epam.maksym_yena.java.lecture_8.task_6.part2;

public class StringCalculator {

    private final int LIMIT_VALUE = 1000;

    public int add(String input) throws Exception {

        String[] numbers = input.split(",|\n");

        if (isEmpty(input)) {
            return 0;
        }
        if((input.startsWith("//") && (input.contains("\\")))) {
            int result = 0;
            for(int i = 0; i < input.length() ; i++) {
                if (Character.isDigit(input.charAt(i))) {
                    result += stringToInt(String.valueOf(input.charAt(i)));
                }
            }
            return result;
        }
        if (input.length() == 1) {
            return stringToInt(input);
        } else {
            return getSum(numbers);
        }
    }

    public int stringToInt(String value) {
        return Integer.parseInt(value);
    }

    public boolean isEmpty(String value) {
        return value.isEmpty();
    }

    public int getSum(String[] number) throws Exception {
        int counter = 0;

        for(int j = 0; j < number.length; j ++) {
            if(stringToInt(number[j]) < 0) {
                System.out.print(stringToInt(number[j]));
                counter++;
                }
        }

        if(counter > 0) {
            throw new Exception();
        }

        int sum = 0;
        for(String value : number) {
            if(stringToInt(value) > LIMIT_VALUE) {
                continue;
            }
            sum += stringToInt(value);
        }
        return sum;
    }
}