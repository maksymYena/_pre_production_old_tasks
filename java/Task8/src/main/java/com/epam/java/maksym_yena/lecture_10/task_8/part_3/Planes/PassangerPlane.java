package com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes;

import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.Plane;

import java.io.Serializable;

public class PassangerPlane extends Plane implements Serializable {
    private int countOfPassangers = 0;

    public int getCountOfPassangers() {
        return countOfPassangers;
    }

    public void setCountOfPassangers(int countOfPassangers) {
        this.countOfPassangers = countOfPassangers;
    }

    public PassangerPlane(String name, double weight, int maxSpeed, double fuelConsumption,
                          int fuelTank, int carriage, int maxCapacity, int countOfPassangers, int getFlghtRange) {
        super(name,weight,maxSpeed,fuelConsumption,fuelTank,carriage,maxCapacity, getFlghtRange);
        this.countOfPassangers = countOfPassangers;
    }

    @Override
    public String toString() {
        return "PassangerPlane{" +
                "countOfPassangers=" + countOfPassangers +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelTank=" + fuelTank +
                ", carriage=" + carriage +
                ", maxCapacity=" + maxCapacity +
                '}';
    }

    @Override
    public double maximumFlight() {
        int metrToKillometer = 1000;
        double result = 0;
        int averageWeight = 60;
        double weightOfPassanger =  getCountOfPassangers() * averageWeight;
        if(getWeight() < weightOfPassanger) {
            System.out.println("The plane cannot fly!");
        }
        else {
            result = ((getWeight() - countOfPassangers * 2)  / metrToKillometer);
            System.out.println("The plane can fly! It max height of flight: " + result + " killometer(s)");
        }
        return result;
    }
}
