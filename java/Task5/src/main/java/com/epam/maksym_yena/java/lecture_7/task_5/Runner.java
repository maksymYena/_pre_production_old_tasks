package com.epam.maksym_yena.java.lecture_7.task_5;

import com.epam.maksym_yena.java.lecture_7.task_5.data.Course;
import com.epam.maksym_yena.java.lecture_7.task_5.data.Curriculum;
import com.epam.maksym_yena.java.lecture_7.task_5.data.Student;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

import static com.epam.maksym_yena.java.lecture_7.task_5.reports.Reports.reportLong;
import static com.epam.maksym_yena.java.lecture_7.task_5.reports.Reports.reportShort;

public class Runner {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args)  {

        int value;

        ZoneId zone = ZoneId.of("Europe/Kiev");

        ZonedDateTime start = ZonedDateTime.of(2020, 8, 6, 18, 0, 0, 0,zone);
        ZonedDateTime end = ZonedDateTime.now(zone);

        Curriculum JAVA = new Curriculum(" JAVA Developer");
        Curriculum J2EE = new Curriculum(" J2EE Developer");

        Student firstStudent = new Student(" Ivanov Ivan ",  J2EE );
        Student secondStudent = new Student(" Petrov Petr  ",  JAVA );

        Course[] coursesJ2EE = new Course[] {
                new Course("Технология Java Servlets ", 16,start,end),
                new Course("Struts Framework ", 24,start,end),
        };

        Course[] coursesJAVA = new Course[] {
                new Course("Библиотека JFC/Swing ", 16,start,end),
                new Course("Технология JDBC", 16,start,end),
                new Course("Обзор технологий Java ", 8,start,end),
        };


        do {
            System.out.println("\nInformation about :\n1.First student.\n2.Second student\n0.Exit");
            value = SCANNER.nextInt();
            switch (value) {
                case 1:
                    int choice;
                        System.out.println("What type of report do you wanna?\n");
                        System.out.println("1.Short report\n2.Long report\n0.Exit");

                        choice = SCANNER.nextInt();
                        switch (choice) {
                            case 1:
                                reportShort(firstStudent,coursesJ2EE);
                                break;
                            case 2:
                                reportLong(firstStudent,coursesJ2EE,start,end);
                                break;
                            case 0: System.exit(0);
                            default:
                                System.out.println("Try again!");
                        }
                    break;
                case 2:
                        System.out.println("What type of report do you wanna?\n");
                        System.out.println("1.Short report\n2.Long report\n0.Exit");

                        choice = SCANNER.nextInt();
                        switch (choice) {
                            case 1:
                                reportShort(secondStudent,coursesJAVA);
                                break;
                            case 2:
                                reportLong(secondStudent,coursesJAVA,start,end);
                                break;
                            case 0: System.exit(0);
                            default:
                                System.out.println("Try again!");
                        }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Ooops..");
            }
        }
        while(0!=value);
    }

    public static void checkContinuedStudying(long result, Course[] array, Student student) {
        if(result < Course.countDuringCourses(array)) {
            long tmp = Course.countDuringCourses(array) - result;
            long days = tmp / 8;
            long hours = tmp % 8;
            System.out.println( student.getNameStudent() + " - Обучение не закончено. До окончания осталось " + days + " д " + hours + " ч.");
        }
        else {
            long days = result / 8;
            long hours = result % 8;
            System.out.println("Обучение закончено. После окончания прошло " + days + " д " + hours + " ч.");
        }
    }

    public static void displayInfo(Student firstStudent,
                                   Student secondStudent,
                                   Course[] coursesJ2EE,
                                   Course[] coursesJAVA,
                                   ZonedDateTime end)
    {
        System.out.println(firstStudent.toString());
        System.out.println("Start data : " + end);
        System.out.println("Course\t\t\tDuration(hrs)");
        System.out.println("-----------------------------");

        for(int i = 0; i < coursesJ2EE.length; i++) {
            System.out.println((i+1) +  "." + coursesJ2EE[i].toString());
        }

        System.out.println("\n\n");

        System.out.println(secondStudent.toString());
        System.out.println("Start data : " + end);
        System.out.println("Course\t\t\tDuration(hrs)");
        System.out.println("-----------------------------");

        for(int i = 0; i < coursesJAVA.length; i++) {
            System.out.println((i+1) +  "." + coursesJAVA[i].toString());
        }
    }


}
