package com.epam.maksym_yena.java.lecture_7.task_5.data;

import java.time.ZonedDateTime;

public class Course {
    private String nameCourse;
    private int durationHours;
    private ZonedDateTime start;
    private ZonedDateTime end;

    public Course(String nameCourse, int durationHours, ZonedDateTime start, ZonedDateTime end) {
        this.nameCourse = nameCourse;
        this.durationHours = durationHours;
        this.start = start;
        this.end = end;
    }

    public static int countDuringCourses(Course[] courses) {

        int duringCourseTime=0;

        for(int i = 0; i < courses.length; i++) {

            duringCourseTime+=courses[i].getDurationHours();

        }
        return duringCourseTime;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    @Override
    public String toString() {
        return  nameCourse + " " + durationHours;
    }
}
