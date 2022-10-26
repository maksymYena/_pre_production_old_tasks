package com.epam.maksym_yena.java.lecture_7.task_5.reports;

import com.epam.maksym_yena.java.lecture_7.task_5.data.Course;
import com.epam.maksym_yena.java.lecture_7.task_5.data.Student;

import java.time.ZonedDateTime;

import static com.epam.maksym_yena.java.lecture_7.task_5.Runner.checkContinuedStudying;
import static com.epam.maksym_yena.java.lecture_7.task_5.calculate.Calculator.calculateDate;

public class Reports {

    public final static int WORKING_HOURS = 8;

    public static void reportLong(Student student,
                                  Course[] courses,
                                  ZonedDateTime start,
                                  ZonedDateTime end)
    {

        int tmp = Course.countDuringCourses(courses);
        System.out.println(student.toString());
        System.out.println("During a program : " + tmp);
        tmp/=WORKING_HOURS;
        System.out.println("Start education : " + start);
        System.out.println("End education : " + start.plusDays(tmp));

        long calcul = calculateDate(start,end);
        checkContinuedStudying(calcul,courses,student);
    }

    public static void reportShort(Student student,
                                   Course[] courses)
    {
        int tmp = Course.countDuringCourses(courses);
        System.out.println(student.toString());
    }
}
