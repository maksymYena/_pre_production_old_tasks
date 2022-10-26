package com.epam.java.maksym_yena.lecture_10.task_8.part_3;


import com.epam.java.maksym_yena.lecture_10.task_8.part_3.AirCompany.Company;
import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.CargoAirplane;
import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.MilitaryPlane;
import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.PassangerPlane;
import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.Plane;
import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Sorted.sortedBy;

import java.io.*;

public class Runner implements Serializable {

    public static void main(String[] args) {

        Company airCompany = new Company("Max",10);

        Plane object1 = new CargoAirplane("C1",10000,700,1,
                400,10,300,150,10);

        Plane object2 = new CargoAirplane("C2",20000,800,150,
                600,20,400,160,1);

        Plane object3 = new PassangerPlane("P1",50000,400,10,
                360,15,500,40,20);


        Plane object4 = new PassangerPlane("P2",15000,500,2,
                400,25,600,40,13);

        Plane[] planes = new Plane[4];

        planes[0] = object1;
        planes[1] = object2;
        planes[2] = object3;
        planes[3] = object4;

        System.out.println("Function maximum flies for all objects : ");
        object1.maximumFlight();
        object2.maximumFlight();
        object3.maximumFlight();
        object4.maximumFlight();

        MilitaryPlane object5 = new MilitaryPlane("M1",12000,600,40,60,180,
                300,"F_50",11000);

        System.out.println("\nInformation about :" + object5.getName() +
                " , it has got speed : " + object5.getMaxSpeed() + " km");

        object5.maximumFlight();

        object5.disguise(object5);

        object5.increaseSpeed(object5,1000);

        System.out.println("After increasing speed of : " + object5.getName() + " speed = " + object5.getMaxSpeed());

        System.out.print("\nSum of carriage  : " + airCompany.getSumCarriage(planes) + "\n");

        System.out.print("\nSum of capacity : " + airCompany.getSumCapacity(planes) + "\n");

        System.out.println("\nBefore sorting");

        for(Plane obj : planes) {
            System.out.println("Name : " + obj.getName() + " " + " flghtRange: " + obj.getGetFlghtRange());
        }

        System.out.println("\nAfter sorting");

        sortedBy sortedBy = new sortedBy();

        sortedBy.sortByDistance(planes);

        System.out.println("\nSearch plane for parameters : ");

        sortedBy.findPlane(planes,
                10000,
                700,
                1,
                400,
                10,
                300,
                150);

        System.out.println("Serialization");
        String tmp = Connector.serialization(planes);
        System.out.println("Deserialization");
        Connector.deserialization(tmp, planes);
    }
}
