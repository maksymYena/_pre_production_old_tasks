package com.epam.java.maksym_yena.lecture_10.task_8.part_3.Characteristic;

import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.MilitaryPlane;

public interface IMilitary {

    MilitaryPlane increaseSpeed(MilitaryPlane plane, int newSpeed);

    String disguise(MilitaryPlane plane);

}
