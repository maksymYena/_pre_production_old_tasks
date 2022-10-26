package com.epam.maksym_yena.java.lecture_7.task_5.calculate;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public static long calculateDate(ZonedDateTime start, ZonedDateTime end) {

        LocalTime startWork = LocalTime.of(10, 0);
        LocalTime endWork = LocalTime.of(18, 0);

        long countOfHours = 0;

        ZonedDateTime startHour = start;

        if (start.toLocalTime().isBefore(endWork)) {
            startHour = start.with(startWork);
        } else if (start.toLocalTime().isAfter(endWork)) {
            startHour = start.with(endWork);
        }

        ZonedDateTime endHour = end;

        if (end.toLocalTime().isAfter(endWork)) {
            endHour = end.with(endWork);
        } else if (end.toLocalTime().isBefore(startWork)) {
            endHour = end.with(startWork);
        }

        while(startHour.isBefore(endHour)) {
            if (startHour.toLocalDate().equals(endHour.toLocalDate())) {
                countOfHours += ChronoUnit.HOURS.between(startHour, endHour);
                break;
            } else {
                ZonedDateTime endOfDay = startHour.with(endWork);
                countOfHours += ChronoUnit.HOURS.between(startHour, endOfDay);
                startHour = startHour.plusDays(1).with(startWork);
            }
        }
        return  countOfHours;
    }
}
