package com.epam.maksym_yena.java.lecture_5.task_1.Task1.Planes;

import com.epam.maksym_yena.java.lecture_5.task_1.Task1.Characteristic.IMilitary;

public class MilitaryPlane extends Plane implements IMilitary {

    String type;

    public MilitaryPlane(String name, double weight, int maxSpeed, double fuelConsumption,
                         int fuelTank, int carriage, int maxCapacity, String type, int getFlghtRange) {
        super(name, weight, maxSpeed, fuelConsumption, fuelTank, carriage, maxCapacity, getFlghtRange);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double maximumFlight() {
        int METR_TO_KILLOMETER = 1000;
        double tmp = (getWeight() * getMaxSpeed()) / (Math.PI * (Math.pow(Math.PI, Math.E)));
        double result = 0;
        if(tmp < (getMaxSpeed() * Math.PI)) {
            System.out.println("The plane cannot fly!");
        }
        else {
            result = tmp  / METR_TO_KILLOMETER;
            System.out.println("The plane can fly! It max height of flight: " + result + " killometer(s)");
        }
        return result;
    }

    @Override
    public MilitaryPlane increaseSpeed(MilitaryPlane plane, int newSpeed) {
        plane.setMaxSpeed(newSpeed);
        return plane;
    }

    @Override
    public String disguise(MilitaryPlane plane) {
        String disguised = "";
        if((plane.type.equals("AH") || (plane.type.equals("F_50")))) {
            System.out.println("Disguise [Black/White]");
            disguised = "Black/White";
        }
        else {
            System.out.println("Not found disguise");
            disguised = "NONE";
        }
        return  disguised;
    }
}
