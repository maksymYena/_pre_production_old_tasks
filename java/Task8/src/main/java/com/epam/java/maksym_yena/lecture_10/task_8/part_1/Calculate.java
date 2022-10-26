package com.epam.java.maksym_yena.lecture_10.task_8.part_1;
import java.io.*;
import java.util.*;


public class Calculate {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void menu() throws IOException  {
        int choose;
        do {
            System.out.println("\nInput link to file : ");
            String link = SCANNER.next();
            List<String> list = new ArrayList<String>();
            File myfile = new File(link);
            FileReader fr = new FileReader(myfile);
            BufferedReader reader = new BufferedReader(fr);
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
            System.out.println("1.frequency\n2.length\n3.duplicates\n4.exit");
            choose = SCANNER.nextInt();
            switch (choose) {
                case 1:
                    isFrequancy(list);
                    break;
                case 2:
                    checkLength(list);
                    break;
                case 3:
                    findDuplicates(list);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }
        while (!"4".equals(choose));
    }

    public void isFrequancy(List<String> array) {
        Map<String,Integer> frequent = new HashMap<String, Integer>();
        for (int i = 0; i < array.size(); i++) {
            String tempChar = array.get(i);
            if (!frequent.containsKey(tempChar)) {
                frequent.put(tempChar, 1);
            } else {
                frequent.put(tempChar, frequent.get(tempChar) + 1);
            }
        }

        for (Map.Entry<String, Integer> value : frequent.entrySet()) {
            System.out.println("Word = " + value.getKey() + ",  repeated = " + value.getValue());
        }
    }

    public  void checkLength(List<String> array) {
        List<String> tmp = array;

        Collections.sort(tmp, Comparator.comparingInt(String::length).reversed());

        for(int  i = 0; i < 3; i++) {
            System.out.println(tmp.get(i) + " :  " + tmp.get(i).length());
        }
    }



    public  void findDuplicates(List<String> array) {
        List<String> strings = new ArrayList<>();
        List<String> dubpicates = new ArrayList<>();
        Map<String, Integer> mapWithoutDublicates = new HashMap<>();

        for (int i = 0; i < array.size(); i++) {
            String tempString = array.get(i);
            if (!mapWithoutDublicates.containsKey(tempString)) {
                mapWithoutDublicates.put(tempString, i);
            } else {
                dubpicates.add(tempString.toUpperCase());
            }
        }

        for(int i = 0; i < dubpicates.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder(dubpicates.get(i));
            strings.add(stringBuilder.reverse().toString());
        }

        Collections.sort(strings, Comparator.comparingInt(String::length));

        for(int i = 0; i < strings.size(); i++) {
            System.out.println("Dubpicates [" + (i+1) +  "] = " + strings.get(i));
        }
    }
}
