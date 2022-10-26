package com.epam.java.maksym_yena.lecture_10.task_8.part_3;

import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.Plane;

import java.io.*;
import java.util.Scanner;

public class Connector {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String  serialization(Plane[] planes) {

        System.out.println("Input file name : ");
        String filename = SCANNER.next();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(planes);
            System.out.println("File has been written");
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return filename;
    }

    public static void deserialization(String filename, Plane[] planes) {
        Plane[] newPlane = new Plane[planes.length];

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            newPlane= (Plane[]) ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        for(Plane plane : newPlane) {
            System.out.println("Plane name : " + plane.getName() + " , " + plane.toString());
        }

    }
}
