package com.epam.maksym_yena.java.lecture_5.task_1.Task1.Characteristic;

import com.epam.maksym_yena.java.lecture_5.task_1.Task1.Planes.MilitaryPlane;

public interface IMilitary {

    MilitaryPlane increaseSpeed(MilitaryPlane plane, int newSpeed);

    String disguise(MilitaryPlane plane);

}
